package com.example.demo;


import com.example.loose.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")


public class AppConfig {
    @Bean(initMethod = "init" , destroyMethod = "cleanUp") //another way to create a bean
    public LifeCycleBean lifeCycleBean(NotificationService notificationService){
        return new LifeCycleBean(notificationService);
    }
}
