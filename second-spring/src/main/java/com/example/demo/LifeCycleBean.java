package com.example.demo;

import com.example.loose.NotificationService;

public class LifeCycleBean {
    private NotificationService notificationService;

    public LifeCycleBean(NotificationService notificationService){
        System.out.println("constructor called : dependency injected");
        this.notificationService = notificationService;
    }

    public void init(){
        System.out.println("init called : bean initialized");
        notificationService.send("hello from init()");
    }

    public void performTask(){
        System.out.println("ready for used");
    }

    public void cleanUp(){
        System.out.println("cleanup() is called ");
    }
}
