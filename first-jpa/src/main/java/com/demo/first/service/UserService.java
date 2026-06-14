package com.demo.first.service;

import com.demo.first.Repository.UserRepository;
import com.demo.first.controller.UserController;
import com.demo.first.exceptions.UserNotFoundException;
import com.demo.first.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    private final Logger logger = LoggerFactory.getLogger(UserService.class); //only lower level logs are visible

    public User createUser(User user) {
        logger.info("Creating User.......INFO");
        logger.debug("Creating User......DEBUG");
        logger.error("Creating User......ERROR");
        logger.trace("Creating User......TRACE");
        logger.warn("Creating User.......WARN");
        return userRepository.save(user);
    }

    public User updateUser(User user) {
//        if(!userDb.containsKey(user.getId())){
//            logger.error("error with id {}" , user.getId()); //show in the logs
//            throw new IllegalArgumentException("userID : "+user.getId()+" does not exist");
//        }
        Optional<User> userOptional = userRepository.findById(user.getId());
        User existing = userOptional.orElseThrow(()->new IllegalArgumentException("userID : "+user.getId()+" does not exist"));
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return userRepository.save(existing);
    }

    public boolean deleteUser(int id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("user with id "+id+" does not exists");
        }
        userRepository.deleteById(id);
        return true;
    }

    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            throw new NullPointerException("no user found in database");
        }
        return users;
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("no user by id :"+id+"in datbase"));
    }

    public List<User> searchUsers(String name, String email) {
        return userRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name , email);
    }
}
