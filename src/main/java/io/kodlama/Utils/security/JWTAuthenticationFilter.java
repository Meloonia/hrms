package io.kodlama.Utils.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.kodlama.Entites.dto.EmployerDto;
import io.kodlama.Entites.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final Map<String, Integer> ipBruteForceAttempt = new HashMap<>();
    private final AuthenticationManager authenticationManager;
    private final ObjectMapper objectMapper;
    private final SecurityJwtService securityJwtService;

    public JWTAuthenticationFilter(
            AuthenticationManager authenticationManager,
            ObjectMapper objectMapper,
            SecurityJwtService securityJwtService) {
        this.objectMapper = objectMapper;
        this.authenticationManager = authenticationManager;
        this.securityJwtService=securityJwtService;
    }

    //<http://localhost:port/login
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        if (ipBruteForceAttempt.containsKey(req.getRemoteAddr()) && ipBruteForceAttempt.get(req.getRemoteAddr()) > 50) {
            return null;
        }
        ipBruteForceAttempt.put(req.getRemoteAddr(), (ipBruteForceAttempt.containsKey(req.getRemoteAddr()) ? (ipBruteForceAttempt.get(req.getRemoteAddr()) + 1) : 1));
        try {
            LoginUserModel creds = new ObjectMapper().readValue(req.getInputStream(), LoginUserModel.class);
            logger.info(String.format("Login Attempt %s from %s (%s)", creds.getKullaniciAdi(), req.getRemoteAddr(), req.getRemoteHost()));
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getKullaniciAdi(), creds.getSifre()));
            return authenticate;
        } catch (IOException e) {
            System.out.println("Login Failed!: " + e.getMessage());
            if (logger.isErrorEnabled()) {
                logger.error(e.getMessage(), e);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        ipBruteForceAttempt.remove(req.getRemoteAddr());
        org.springframework.security.core.userdetails.User springKullanici = (org.springframework.security.core.userdetails.User) auth
                .getPrincipal();
        logger.info(String.format("Login Attempt Success for %s from %s (%s)", springKullanici.getUsername(), req.getRemoteAddr(), req.getRemoteHost()));
        res.addHeader("Content-Type", "application/json; charset: UTF-8");

        try {
            LoginUserModel sonucModel = new LoginUserModel();
            sonucModel.setKullaniciAdi(springKullanici.getUsername());
            sonucModel.setToken(securityJwtService.generateJwt(objectMapper.writeValueAsString(new UserDto())));
            res.setHeader("Authorization", sonucModel.getToken());
            res.getOutputStream().write(objectMapper.writeValueAsString(sonucModel).getBytes(StandardCharsets.UTF_8));
            res.setStatus(HttpServletResponse.SC_OK);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SecurityException e) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}