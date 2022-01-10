package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    @Autowired
    com.lyztweet.tweet.Repositories.userRepository userRepository;
    //Sign Up
    @PostMapping("/user")
    public User Sign_Up() {
        User user = new User();
        user.setUsername("123");
        user.setPasswords("123");
        return userRepository.save(user);
    }

    //Sign In
    @GetMapping("/user/{id}")
    public List<User> Sign_In(@PathVariable("id") long id){
        List<User> User = userRepository.findById(id);
        return User;
    }
}
