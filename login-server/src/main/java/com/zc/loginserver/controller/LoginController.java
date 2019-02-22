package com.zc.loginserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhuCan on 2018/12/25.
 * Project parent.
 * Date 2018/12/25   Time 9:18.
 */
@Controller
public class LoginController {

    @RequestMapping("/welcome")
    public String index(Model model) {
        model.addAttribute("msg", "index!");

        return "home/welcome";
    }

    @RequestMapping("/admin")
    public String hello() {
        return "home/welcome";
    }

    @RequestMapping("/login")
    public String login() {
        return "home/login";
    }


}
