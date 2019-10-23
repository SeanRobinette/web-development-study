package com.robinette.didemo.controllers;

import com.robinette.didemo.services.GreetingServiceImpl;
import com.robinette.didemo.services.SetterGreetingService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetterInjectedControllerTest {

    private SetterInjectedController setterInjectedController;

    @Before
    public void setUp() throws Exception {
        setterInjectedController = new SetterInjectedController();
        setterInjectedController.setGreetingService(new SetterGreetingService());
    }

    @Test
    public void sayHello() {
        assertEquals(setterInjectedController.sayHello(), SetterGreetingService.GREETING);
    }
}