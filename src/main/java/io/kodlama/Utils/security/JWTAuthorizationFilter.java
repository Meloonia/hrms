package io.kodlama.Utils.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.kodlama.Entites.dto.EmployerDto;
import io.kodlama.Entites.dto.UserDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Collections;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private final SecurityJwtService securityJwtService;
    private final ObjectMapper objectMapper;
    private final LoginAttemptService loginAttemptService;

    public JWTAuthorizationFilter(
            AuthenticationManager authManager,
            SecurityJwtService securityJwtService,
            ObjectMapper objectMapper,
            LoginAttemptService loginAttemptService) {
        super(authManager);
        this.securityJwtService = securityJwtService;
        this.objectMapper = objectMapper;
        this.loginAttemptService = loginAttemptService;
    }

    @SuppressWarnings("java:S5843")
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        if (loginAttemptService.isBlocked(req.getRemoteAddr())) {
            return;
        }

        if (req.getMethod().equals(HttpMethod.OPTIONS.name())) {
            logger.info(String.format("Option requested from: %s", req.getRemoteAddr()));
            chain.doFilter(req, res);
            return;
        }
        String header = req.getHeader("Authorization");
        if (header == null) {
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req, res);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    @SuppressWarnings("java:S3776")
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token) || !securityJwtService.validateJwt(token)) {
            return null;
        }
        try {
            UserDto kullanici = new ObjectMapper().readValue(Base64.getDecoder().decode(token.substring(token.indexOf('.') + 1, token.lastIndexOf('.'))), UserDto.class);
            response.setHeader("Authorization", token);
            return new UsernamePasswordAuthenticationToken(kullanici.getEmail(), null, Collections.emptyList());
        } catch (IOException e) {
            if (logger.isErrorEnabled()) {
                logger.error(e.getMessage(), e);
            }
            return null;
        }
    }
}
