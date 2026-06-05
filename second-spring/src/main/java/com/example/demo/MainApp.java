package com.example.demo;

import com.example.loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        System.out.println("starting spring application context");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService greetingService = (GreetingService) context.getBean("myBean");

        greetingService.sayHello();

        UserService userService = (UserService) context.getBean("UserServiceSMS");
        //or
        //UserService userService = context.getBean(UserService.class);

        userService.notifyUser("hiiii this is sms notification");

        System.out.println("retrieve life cycle bean");
        LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);

        lifeCycleBean.performTask();

        System.out.println("closing spring context");
    }
}
