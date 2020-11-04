package com.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * spring security安全配置：用户信息、密码编码器、安全拦截机制
 *
 * @author : OlinH
 * @version : v1.0
 * @since : 2020/11/4
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置用户信息服务
     *
     * @return {UserDetailsService}
     */
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager memoryUserDetailsManager = new InMemoryUserDetailsManager();
        // 创建zhangsan、lisi两个用户、并设置密码和权限
        memoryUserDetailsManager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        memoryUserDetailsManager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return memoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 配置安全拦截机制
     *
     * @param http ：HttpSecurity
     * @throws Exception ：异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 授权请求
                .authorizeRequests()
                // 访问/r/r1资源的url需要拥有p1权限
                .antMatchers("/r/r1").hasAuthority("p1")
                // 访问/r/r2资源的url需要拥有p2权限
                .antMatchers("/r/r2").hasAuthority("p2")
                // url匹配/r/**的资源，经过认证后才能访问
                .antMatchers("/r/**").authenticated()
                // 其他url完全开放
                .anyRequest().permitAll()
                .and()
                // 支持form表单认证，认证成功后转向/login-success
                .formLogin().successForwardUrl("/login-success");
    }
}
