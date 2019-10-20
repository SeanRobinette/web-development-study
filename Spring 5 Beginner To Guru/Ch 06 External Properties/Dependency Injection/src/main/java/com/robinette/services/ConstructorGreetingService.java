package com.robinette.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService {
    public static final String GREETING = "Hello from the constructor-injected GreetingService!";

    @Override
    public String sayGreeting() {
        return GREETING;
    }
}
