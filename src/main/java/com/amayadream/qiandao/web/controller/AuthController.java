package com.amayadream.qiandao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 认证控制器
 * @author :  Amayadream
 * @date :  2017.03.15 17:15
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    /**
     * 跳转至登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/auth/login";
    }

    /**
     * 跳转至注册页面
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/auth/register";
    }


}
