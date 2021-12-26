package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class User_controller {

    //Sign Up
    @PostMapping("/user")
    public User Sign_Up() {
        User u = new User();
        u.setId("1");
        u.setUsername("1");
        u.setPasswords("1");
        return u;
    }

    //Sign In
    @GetMapping("/user/{id}")
    public boolean Sign_In(@PathVariable("id") String ID){
        User u = new User();
        u.setId("2");
        u.setUsername("2");
        u.setPasswords("2");
        return true;
    }
}
