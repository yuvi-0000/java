package com.demo.first.controller;

import com.demo.first.model.User;
import com.demo.first.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")

public class UserController {
    UserService userService ;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){ // the body we send it to postman is converted to user object
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); //can also send the String
        // return new ResponseEntity<>(user , HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User userUpdated = userService.updateUser(user);
        if(userUpdated == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(userUpdated , HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //dyamic url --> /user/1
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean isDeleted = userService.deleteUser(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("user deleted");
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUser();
    }
    // dynamic URL
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable("userId") int id){ //to match variable name
        User user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    //multiple path variable
    @GetMapping("/{userId}/order/{orderId}")
    public ResponseEntity<User> getOrder(@PathVariable("userId") int id , @PathVariable int orderId){
        User user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    //search?name=yuvi
    @GetMapping("/search")
    public ResponseEntity<List<User>> search(@RequestParam(required = false , defaultValue = "hahaahaaa") String name, //this is optional
                                            @RequestParam(required = false , defaultValue = "yahooo") String email){ //this is optional

        return ResponseEntity.status(HttpStatus.OK).body(userService.searchUsers(name,email));
    }

    @GetMapping("/info")
    public String getInfo(@RequestHeader("User-Agent") String userAgent){
        return "User Agent: "+userAgent;
    } 
}
