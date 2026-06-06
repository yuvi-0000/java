package com.demo.first.service;

import com.demo.first.controller.UserController;
import com.demo.first.exceptions.UserNotFoundException;
import com.demo.first.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class UserService {

    private Map<Integer , User> userDb = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(UserService.class); //only lower level logs are visible

    public User createUser(User user) {
        logger.info("Creating User.......INFO");
        logger.debug("Creating User......DEBUG");
        logger.error("Creating User......ERROR");
        logger.trace("Creating User......TRACE");
        logger.warn("Creating User.......WARN");
        userDb.putIfAbsent(user.getId(), user);
        return user;
    }

    public User updateUser(User user) {
        if(!userDb.containsKey(user.getId())){
            logger.error("error with id {}" , user.getId()); //show in the logs
            throw new IllegalArgumentException("userID : "+user.getId()+" does not exist");
        }
        userDb.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(int id) {
        if(!userDb.containsKey(id)){
            throw new UserNotFoundException("user with id "+id+" does not exists");
        }
        userDb.remove(id);
        return true;
    }

    public List<User> getAllUser() {
        return new ArrayList<>(userDb.values());
    }

    public User getUserById(int id) {
        return userDb.get(id);
    }

    public List<User> searchUsers(String name, String email) {
        return new ArrayList<>(userDb.values());
    }
}
