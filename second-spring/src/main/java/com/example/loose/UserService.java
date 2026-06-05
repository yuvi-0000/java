package com.example.loose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("UserServiceSMS")

public class UserService {
    public NotificationService notificationService;

    public UserService(){

    }
    @Autowired // more than 1 constructor
    public UserService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void notifyUser(String message){
        notificationService.send("notification hello!");
    }
}
