package com.amayadream.qiandao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index() {
        return "/index";
    }

}
