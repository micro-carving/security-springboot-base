package com.security.springboot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 *
 * @author : OlinH
 * @version : v1.0
 * @since : 2020/11/4
 */
@RestController
public class LoginController {

    /**
     * 输入账号密码，登录成功之后的跳转路径
     * 请求路径：localhost:8080/security-springboot/
     *
     * @return {String}
     */
    @RequestMapping(value = "/login-success")
    public String loginSuccess() {
        return "登录成功";
    }

    /**
     * 拥有p1权限访问的资源/r/r1
     * 请求路径：localhost:8080/security-springboot/r/r1
     *
     * @return {String}
     */
    @GetMapping(value = "/r/r1")
    public String r1() {
        return "访问资源1";
    }

    /**
     * 拥有p1权限访问的资源/r/r2
     * 请求路径：localhost:8080/security-springboot/r/r2
     *
     * @return {String}
     */
    @GetMapping(value = "/r/r2")
    public String r2() {
        return "访问资源2";
    }
}
