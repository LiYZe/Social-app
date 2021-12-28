package com.lyztweet.tweet.controllers;

import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;

@RestController
public class Tweet_controller {

    //create a new Tweet
    @PostMapping("/tweet")
    public Tweet postTweet() {
        Tweet new_tweet = new Tweet();
        new_tweet.setTweet_id("1");
        new_tweet.setContent("test");
        return new_tweet;
    }

    //retrieve a Tweet
    @GetMapping("/tweet/{tweet_id}")
    public Tweet getTweet(@PathVariable("tweet_id") String tweet_id) {
        Tweet t = new Tweet();
        t.setTweet_id(tweet_id);
        t.setContent("test");
        return t;
    }

    //updata a tweet
    @PutMapping("/tweet/{tweet_id}")
    public Tweet updataTweet(@PathVariable("tweet_id") String tweet_id) {
        Tweet t = new Tweet();
        t.setTweet_id(tweet_id);
        t.setContent("updatetest");
        return t;
    }

    //delete a tweet
    @DeleteMapping("/tweet/{tweet_id}")
    public boolean deleteTweet(@PathVariable("tweet_id") String tweet_id) {
        Tweet t = new Tweet();
        t.setTweet_id("delete");
        t.setContent("deletetest");
        return true;
    }
}
