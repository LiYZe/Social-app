package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.Repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;

@RestController
public class Tweet_controller {

    @Autowired
    TweetRepository tweetRepository;

    //create a new Tweet
    @PostMapping("/tweet")
    public Tweet postTweet() {
        Tweet new_tweet = new Tweet();
        return new_tweet;
    }

    //retrieve a Tweet
    @GetMapping("/tweet/{tweet_id}")
    public Tweet getTweet(@PathVariable("tweet_id") String tweet_id) {
        Tweet t = new Tweet();
        return t;
    }

    //updata a tweet
    @PutMapping("/tweet/{tweet_id}")
    public Tweet updataTweet(@PathVariable("tweet_id") String tweet_id) {
        Tweet t = new Tweet();
        return t;
    }

    //delete a tweet
    @DeleteMapping("/tweet/{tweet_id}")
    public boolean deleteTweet(@PathVariable("tweet_id") String tweet_id) {
        Tweet t = new Tweet();
        return true;
    }
}
