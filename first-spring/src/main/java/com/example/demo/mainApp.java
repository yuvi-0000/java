package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainApp {
    public static void main() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationBeanContext.xml");

        GreetingService greetingService = (GreetingService) context.getBean("myBean");
        //IoC(Inversion of Control) --> create object using spring framework

        greetingService.sayHello();
    }
}
