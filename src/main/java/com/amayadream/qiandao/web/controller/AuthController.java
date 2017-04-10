package com.amayadream.qiandao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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
    public String loginPage() {
        return "/auth/login";
    }

    /**
     * 跳转至注册页面
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "/auth/register";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String email, String password, HttpSession session, RedirectAttributes attributes) {

        return "redirect:/auth/login";
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String email, String password, RedirectAttributes attributes) {

        return "redirect:/auth/login";
    }

    /**
     * 注销
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }


}
