package com.lyztweet.tweet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class tweetController {
//tweetController
    @Autowired
com.lyztweet.tweet.Repositories.tweetRepository tweetRepository;

    @Autowired
    com.lyztweet.tweet.Repositories.userRepository userRepository;

    //create a new Tweet
    @PostMapping("/tweet")
    public Tweet postTweet() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return tweetRepository.save(new Tweet("text", timestamp, -1));
    }

    //retrieve a Tweet
    @GetMapping("/tweet/{tweet_id}")
    public List<Tweet> getTweet(@PathVariable("tweet_id") long tweet_id) {
        return tweetRepository.findById(tweet_id);
    }

    //update a tweet
    @PutMapping("/tweet/{tweet_id}")
    public Boolean updateTweet(@PathVariable("tweet_id") long tweet_id) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return tweetRepository.updateByTweet_id(tweet_id,"new content",timestamp);
    }

    //delete a tweet
    @DeleteMapping("/tweet/{tweet_id}")
    public boolean deleteTweet(@PathVariable("tweet_id") long tweet_id) {

        return tweetRepository.deleteByTweet_id(tweet_id);
    }

    //Retweet
    //post a retweet
    @PostMapping("/user/{id}/retweet/{source_tweet_id}")
    public Tweet postRetweet(@PathVariable("id") long id, @PathVariable("source_tweet_id") long source_tweet_id){
        User user = userRepository.findtargetUser(id);
        return tweetRepository.saveRetweet(user, source_tweet_id);
    }
    
    //delete retweet
    @DeleteMapping("/user/{id}/retweet/{source_tweet_id}")
    public boolean deleteRetweet(@PathVariable("id") long id, @PathVariable("source_tweet_id") long source_tweet_id){
        User user = userRepository.findtargetUser(id);
        return tweetRepository.deleteRetweet(user, source_tweet_id);
    }

    //Fetch the user who retweet this tweet
    @GetMapping("/tweet/{tweet_id}/retweeted_by")
    public List<User> getRetweetuser(@PathVariable("tweet_id") long tweet_id){
        return tweetRepository.findRetweetuser(tweet_id);
    }

}
