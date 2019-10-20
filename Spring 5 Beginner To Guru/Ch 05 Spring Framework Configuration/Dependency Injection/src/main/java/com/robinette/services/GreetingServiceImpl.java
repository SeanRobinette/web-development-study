package com.robinette.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    public static final String GREETING = "Hello from GreetingServiceImpl!";

    @Override
    public String sayGreeting() {
        return GREETING;
    }
}
