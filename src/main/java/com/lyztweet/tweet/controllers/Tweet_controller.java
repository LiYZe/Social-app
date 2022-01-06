package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.Repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class Tweet_controller {

    @Autowired
    TweetRepository tweetRepository;

    //create a new Tweet
    @PostMapping("/tweet")
    public Tweet postTweet() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return tweetRepository.save(new Tweet("text", timestamp));
    }

    //retrieve a Tweet
    @GetMapping("/tweet/{tweet_id}")
    public List<Tweet> getTweet(@PathVariable("tweet_id") long tweet_id) {
        return tweetRepository.findById(tweet_id);
    }

    //updata a tweet
    @PutMapping("/tweet/{tweet_id}")
    public Boolean updataTweet(@PathVariable("tweet_id") long tweet_id) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return tweetRepository.updateByTweet_id(tweet_id,"new content",timestamp);
    }

    //delete a tweet
    @DeleteMapping("/tweet/{tweet_id}")
    public boolean deleteTweet(@PathVariable("tweet_id") long tweet_id) {

        return tweetRepository.deleteByTweet_id(tweet_id);
    }
}
