package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.Repositories.UserRepository;
import com.lyztweet.tweet.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class User_controller {

    @Autowired
    UserRepository userRepository;
    //Sign Up
    @PostMapping("/user")
    public String Sign_Up() {
        userRepository.save(new User("123","123"));
        return "User is create";
    }

    //Sign In
    @GetMapping("/user/{id}")
    public List<User> Sign_In(@PathVariable("id") long id){
        List<User> User = userRepository.findById(id);
        return User;
    }
}
