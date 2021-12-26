package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Retweet_controller {

    //Retweet by a user
    @GetMapping("user/{id}/retweet")
    public Retweet user_retweet(@PathVariable("{id}") String id){
        Retweet new_r = new Retweet();
        return new_r;
    }
}
