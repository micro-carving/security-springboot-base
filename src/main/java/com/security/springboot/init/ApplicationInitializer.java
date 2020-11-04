package com.security.springboot.init;

import com.security.springboot.config.WebConfig;
import com.security.springboot.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author : OlinH
 * @version : v1.0
 * @since : 2020/10/25
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定rootContext的配置类，相当于加载applicationContext.xml配置文件
     *
     * @return {Class类型的数组}
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebSecurityConfig.class};
    }

    /**
     * 指定servletContext的配置类，相当于加载spring-mvc.xml
     *
     * @return {Class类型的数组}
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
