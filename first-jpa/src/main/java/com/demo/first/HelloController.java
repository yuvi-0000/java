package com.demo.first;

import com.demo.first.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //is we want to make all the api's like api/hello , api/user

public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    //Jackson convert objects to JSON and vise versa

    // @GetMapping("/user")  same as below
    @RequestMapping(value = "/user" , method = RequestMethod.GET)
    public User getUser(){
        User user = new User(1,"virat" , "virat@example.com");
        return user;
    }
}
