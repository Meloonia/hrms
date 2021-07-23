package io.kodlama.Utils.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.kodlama.Business.Abstracts.UserManagerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final SecurityJwtService securityJwtService;
    private final LoginAttemptService loginAttemptService;
    private UserManagerServices userManagerServices;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public WebSecurityConfig(
            SecurityJwtService securityJwtService,
            UserManagerServices userManagerServices,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            LoginAttemptService loginAttemptService,
            ObjectMapper objectMapper) {
        this.userManagerServices=userManagerServices;
        this.securityJwtService = securityJwtService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.objectMapper = objectMapper;
        this.loginAttemptService = loginAttemptService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userManagerServices).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.cors().and().csrf().disable().authorizeRequests()
                    .antMatchers(HttpMethod.TRACE).denyAll()
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .addFilter(new JWTAuthenticationFilter(authenticationManager(), objectMapper, securityJwtService))
                    .addFilter(new JWTAuthorizationFilter(authenticationManager(), securityJwtService, objectMapper, loginAttemptService))
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        //configuration.setAllowedOriginPatterns(Arrays.asList("https://*.myDomain.com")); * = wildcard
        configuration.setAllowedOriginPatterns(Arrays.asList("*","https://*.*.*", "http://*.*.*","*.*", "http://localhost:*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        List<String> allowedHeaders = new ArrayList<>();
        allowedHeaders.add("Content-type");
        allowedHeaders.add("x-auth-token");
        allowedHeaders.add("x-xsrf-token");
        allowedHeaders.add("Content-Disposition");
        allowedHeaders.add("Origin");
        allowedHeaders.add("Access-Control-Request-Method");
        allowedHeaders.add("Access-Control-Request-Headers");
        allowedHeaders.add("X-PINGOTHER");
        allowedHeaders.add("Cache-Control");
        allowedHeaders.add("Pragma");
        allowedHeaders.add("Expires");
        configuration.setAllowedHeaders(allowedHeaders);
        configuration.setExposedHeaders(Arrays.asList("x-auth-token", "x-xsrf-token", "xsrf-token", "Origin", "Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

