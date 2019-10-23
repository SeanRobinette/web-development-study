package com.robinette.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {
    public static final String GREETING = "Hello from the setter-injected GreetingService!";

    @Override
    public String sayGreeting() {
        return GREETING;
    }
}
