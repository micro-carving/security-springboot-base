package com.security.springboot.init;

import com.security.springboot.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * security应用程序初始化器
 *
 * @author : OlinH
 * @version : v1.0
 * @since : 2020/11/5
 */
public class SecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityApplicationInitializer() {
        super(WebSecurityConfig.class);
    }
}
