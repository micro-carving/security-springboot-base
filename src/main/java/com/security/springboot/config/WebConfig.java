package com.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 拦截器相关配置
 *
 * @author : OlinH
 * @version : v1.0
 * @since : 2020/10/30
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 默认url根路径跳转到/login，此url为spring security提供
     *
     * @param registry ：视图控制器注册中心
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }

    /**
     * 为视图添加跨域映射
     *
     * @param registry ：视图拦截器注册中心
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOrigins("*")
                // 设置允许跨域请求头
                .allowedHeaders("*")
                // 是否允许证书，默认关闭
                //.allowCredentials(true)
                // 设置允许访问方法
                .allowedMethods("GET", "POST")
                // 跨域允许时间
                .maxAge(3600);
    }

    /**
     * 视图解析器
     *
     * @return InternalResourceViewResolver
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
