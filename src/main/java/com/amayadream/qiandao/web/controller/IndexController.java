package com.amayadream.qiandao.web.controller;

import com.amayadream.qiandao.common.util.Constants;
import com.amayadream.qiandao.core.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author :  Amayadream
 * @date :  2017.03.20 21:42
 */
@Controller
@RequestMapping(value = "")
public class IndexController {

    @RequestMapping(value = "/")
    public String toIndex() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index")
    public String index(HttpSession session, Model model) {
        model.addAttribute(Constants.SESSION_USER, session.getAttribute(Constants.SESSION_USER));
        model.addAttribute(Constants.SESSION_FLAG, session.getAttribute(Constants.SESSION_FLAG));
        return "/index";
    }

}
