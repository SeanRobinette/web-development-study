package com.seanrobinette.securitydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaderController {
    @RequestMapping("/leaders")
    public String getLeaderPage() {
        return "leaders";
    }
}
