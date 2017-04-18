package com.amayadream.qiandao.web.controller;

import com.amayadream.qiandao.common.util.Constants;
import com.amayadream.qiandao.common.util.TokenGenerator;
import com.amayadream.qiandao.core.model.User;
import com.amayadream.qiandao.core.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 认证控制器
 * @author :  Amayadream
 * @date :  2017.03.15 17:15
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Resource
    private IUserService userService;

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
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            attributes.addFlashAttribute("error", "邮箱和密码不能为空!");
            return "redirect:/auth/login";
        }
        User user = userService.selectByPrimaryKey(email);
        if (StringUtils.isEmpty(user)) {
            attributes.addFlashAttribute("error", "该用户不存在!");
            return "redirect:/auth/login";
        }
        if (!user.getPassword().equals(DigestUtils.md5Hex(password + user.getSalt()))) {
            attributes.addFlashAttribute("error", "用户密码不正确!");
            return "redirect:/auth/login";
        }
        session.setAttribute(Constants.SESSION_FLAG, true);
        session.setAttribute(Constants.SESSION_USER, user);
        attributes.addFlashAttribute("message", "登录成功!");
        return "redirect:/index";
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String email, String password, RedirectAttributes attributes) {
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            attributes.addFlashAttribute("error", "邮箱和密码不能为空!");
            return "redirect:/auth/register";
        }
        User user = userService.selectByPrimaryKey(email);
        if (!StringUtils.isEmpty(user)) {
            attributes.addFlashAttribute("error", "用户[" + email + "]已经存在!");
            return "redirect:/auth/register";
        }
        String salt = TokenGenerator.getGuid();
        String pwd = DigestUtils.md5Hex(password + salt);
        User u = new User(email, pwd, salt, Constants.ROLE_REGISTER, new Date(), null, Constants.STATUS_USER_NORMAL);
        userService.insert(u);
        attributes.addFlashAttribute("message", "注册成功!");
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
