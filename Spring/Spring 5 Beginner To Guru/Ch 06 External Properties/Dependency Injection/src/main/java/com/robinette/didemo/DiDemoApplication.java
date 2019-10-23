package com.robinette.didemo;

import com.robinette.didemo.controllers.ConstructorInjectedController;
import com.robinette.didemo.controllers.MyController;
import com.robinette.didemo.controllers.PropertyInjectedController;
import com.robinette.didemo.controllers.SetterInjectedController;
import com.robinette.didemo.examplebeans.FakeDataSource;

import com.robinette.didemo.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.robinette.didemo", "com.robinette.services"})
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        System.out.println(((ConstructorInjectedController) ctx.getBean("constructorInjectedController")).sayHello());
        System.out.println(((PropertyInjectedController) ctx.getBean("propertyInjectedController")).sayHello());
        System.out.println(((SetterInjectedController) ctx.getBean("setterInjectedController")).sayHello());

        MyController controller = (MyController) ctx.getBean("myController");
        System.out.println(controller.sayHello());

        FakeDataSource fds = ctx.getBean(FakeDataSource.class);
        System.out.println("Username = " + fds.getUsername());

        FakeJmsBroker jms = ctx.getBean(FakeJmsBroker.class);
        System.out.println("JMS Username = " + jms.getUsername());
    }

}
