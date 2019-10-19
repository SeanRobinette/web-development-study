package com.robinette.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingService implements GreetingService {
    public static final String GREETING = "Hello from the property-injected GreetingService!";

    @Override
    public String sayGreeting() {
        return GREETING;
    }
}
