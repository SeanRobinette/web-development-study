package com.seanrobinette.securitydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/showLoginPage")
    public String showLoginPage(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("error", error != null);
        return "login";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "accessdenied";
    }
}
