package io.kodlama.Core.utilities;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitalizer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitalizer() {
        super(SecurityConfig.class);
    }
}
