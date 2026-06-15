package com.example.db;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private List<String> users ;

    public void init(){
        users = new ArrayList<>();
        System.out.println("DB connected (simulated)");
    }

    public List<String> getUser(){
        return users;
    }

    public void addUser(String user){
        users.add(user);
    }

    public void cleanUp(){
        System.out.println("DB disconnected(simulated)");
    }
}
