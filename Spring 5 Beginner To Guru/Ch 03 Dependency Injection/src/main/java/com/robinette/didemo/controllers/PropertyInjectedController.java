package com.robinette.didemo.controllers;

import com.robinette.didemo.services.GreetingService;
import com.robinette.didemo.services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Autowired
    @Qualifier("propertyGreetingService")
    public GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
