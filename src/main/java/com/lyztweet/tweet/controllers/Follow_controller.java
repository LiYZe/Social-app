package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Follow_controller {
    //follow a user	POST	/user/{id}/following
    //unfollow a user	DELETE	/user/{source_user_id}/following/{target_user_id}
    //check following	Get	/user/{id}/following
    //Check follower	GET	/user/{id}/follower

    //follow a user
    @PostMapping("/user/{id}/following")
    public boolean follow_user(@PathVariable("id") String id){
        return true;
    }

    //unfollow a user
    @DeleteMapping("/user/{source_user_id}/following/{target_user_id}")
    public boolean unfollow_user(@PathVariable("source_user_id") String id, @PathVariable("target_User_id") String target_id){
        return true;
    }

    //check following
    @GetMapping("/user/{id}/following")
    public LinkedList<User> check_following(@PathVariable("id") String id){
        return new LinkedList<User>();
    }

    //check follower
    @GetMapping("/user/{id}/follower")
    public LinkedList<User> check_follower(@PathVariable("id") String id){
        return new LinkedList<User>();
    }
}
