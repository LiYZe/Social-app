package com.lyztweet.tweet.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lyztweet.tweet.models.*;

@RestController
public class Comment_controller {

    //Post a Comment
    @PostMapping("/tweet/{tweet_id}/comment/")
    public Comment postComment(@PathVariable("{tweet_id}") String tweet_id) {
        return new Comment();
    }

    //Delete a Comment
    @DeleteMapping("/tweet/{tweet_id}/comment/")
    public boolean deleteComment(@PathVariable("{tweet_id}") String tweet_id) {
        return true;
    }
}
