package com.example.service;
//all business logic is present in this layer

import org.springframework.stereotype.Service;
import com.example.repository.UserRepository;
import java.util.List;

@Service

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){ //only works if UserRepository is
        this.userRepository = userRepository;         //spring managed component(and we use @Repository)
    }

    public void addUser(String name){
        userRepository.save(name);
    }

    public List<String> getAllUsers(){
        return userRepository.findAll();
    }
}
