package com.robinette.didemo.controllers;

import com.robinette.services.ConstructorGreetingService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructorInjectedControllerTest {

    private ConstructorInjectedController constructorInjectedController;

    @Before
    public void setUp() throws Exception {
        this.constructorInjectedController = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    public void sayHello() {
        assertEquals(constructorInjectedController.sayHello(), ConstructorGreetingService.GREETING);
    }
}