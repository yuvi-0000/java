package com.example.jpademo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserClassSpringBoot createUser(UserClassSpringBoot user){
        return userRepository.save(user); // create or update both
    }

    public List<UserClassSpringBoot> getUser() {
        return userRepository.findAll();
    }
}
