package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.entity.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.dao.userDao;

@RestController
public class userController {

    @Autowired
    userDao userDao;

    //Sign Up
    @PostMapping("/user")
    public userEntity Sign_Up(@RequestBody userEntity user) {
        return userDao.save(user);
    }

    //Sign In
    @GetMapping("/user/{id}")
    public Object Sign_In(@PathVariable("id") long id){
        return userDao.findUserById(id);
    }
}
