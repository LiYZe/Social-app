package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Likes_controller {

    //User like a tweet
    @PostMapping("/user/{id}/like")
    public boolean postLike(@PathVariable("{id}") String id) {
        Likes new_likes = new Likes();
        return true;
    }

    //User undo like
    @DeleteMapping("/user/{id}/like/{tweet_id}")
    public boolean undoLike(@PathVariable("{id}") String id, @PathVariable("{tweet_id}") String tweet_id) {
        Likes new_likes = new Likes();
        return true;
    }

    //Tweet liked by a user
    @GetMapping("/tweet/{tweet_id}/liking_user")
    public LinkedList<User> tweet_liking_user(@PathVariable("{tweet_id}") String tweet_id) {
        LinkedList<User> liking_user = new LinkedList<>();
        return liking_user;
    }

    //User who like a tweet
    @GetMapping("/user/{id}/liked_tweet")
    public LinkedList<User> user_liked_tweet(@PathVariable("{id}") String id) {
        LinkedList<User> liked_tweet = new LinkedList<>();
        return liked_tweet;
    }
}
