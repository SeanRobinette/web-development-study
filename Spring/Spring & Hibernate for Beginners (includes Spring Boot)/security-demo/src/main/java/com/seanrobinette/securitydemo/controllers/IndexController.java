package com.seanrobinette.securitydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class IndexController {

    @RequestMapping({"","/","/index","/index.html"})
    public String index(Model model, Principal principal) {
        return "index";
    }
}
