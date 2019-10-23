package com.robinette.didemo;

import com.robinette.didemo.controllers.ConstructorInjectedController;
import com.robinette.didemo.controllers.MyController;
import com.robinette.didemo.controllers.PropertyInjectedController;
import com.robinette.didemo.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        System.out.println(((ConstructorInjectedController) ctx.getBean("constructorInjectedController")).sayHello());
        System.out.println(((PropertyInjectedController) ctx.getBean("propertyInjectedController")).sayHello());
        System.out.println(((SetterInjectedController) ctx.getBean("setterInjectedController")).sayHello());

        MyController controller = (MyController) ctx.getBean("myController");
        System.out.println(controller.sayHello());
    }

}
