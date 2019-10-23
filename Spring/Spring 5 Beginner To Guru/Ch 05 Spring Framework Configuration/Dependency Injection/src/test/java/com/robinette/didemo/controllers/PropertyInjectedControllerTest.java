package com.robinette.didemo.controllers;

import com.robinette.services.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyInjectedControllerTest {

    private PropertyInjectedController propertyInjectedController;

    @Before
    public void setUp() throws Exception {
        propertyInjectedController = new PropertyInjectedController();
        propertyInjectedController.greetingService = new GreetingServiceImpl();
    }

    @Test
    public void sayHello() {
        assertEquals(propertyInjectedController.sayHello(), GreetingServiceImpl.GREETING);
    }
}