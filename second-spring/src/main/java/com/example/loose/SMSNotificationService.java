package com.example.loose;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //if multiple beans found then this is primary or @Qualifier("bean_name) is used in UserService.java

public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("SMS :"+message);
    }
}
