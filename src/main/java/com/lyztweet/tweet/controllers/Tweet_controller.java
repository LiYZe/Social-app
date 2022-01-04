package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.Repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;


import java.sql.Timestamp;
import java.util.Date;

@RestController
public class Tweet_controller {

    @Autowired
    TweetRepository tweetRepository;

    //create a new Tweet
    @PostMapping("/tweet")
    public String postTweet() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        tweetRepository.save(new Tweet("text", timestamp));
        return "Tweet is create.";
    }

    //retrieve a Tweet
    @GetMapping("/tweet/{tweet_id}")
    public Tweet getTweet(@PathVariable("tweet_id") long tweet_id) {
        Tweet t = (Tweet) tweetRepository.findById(tweet_id);
        return t;
    }

    //updata a tweet
    @PutMapping("/tweet/{tweet_id}")
    public String updataTweet(@PathVariable("tweet_id") long tweet_id) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        tweetRepository.updateByTweet_id(tweet_id,"new content",timestamp);
        return "Tweet is update";
    }

    //delete a tweet
    @DeleteMapping("/tweet/{tweet_id}")
    public String deleteTweet(@PathVariable("tweet_id") long tweet_id) {
        tweetRepository.deleteByTweet_id(tweet_id);
        return "Tweet is delete";
    }
}
