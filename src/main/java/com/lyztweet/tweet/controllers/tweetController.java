package com.lyztweet.tweet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;


import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class tweetController {
    @Autowired
    com.lyztweet.tweet.repositories.tweetRepository tweetRepository;

    @Autowired
    com.lyztweet.tweet.repositories.userRepository userRepository;

    //create a new Tweet
    @PostMapping("/tweet")
    public Tweet postTweet() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return tweetRepository.save(new Tweet("text", timestamp, -1));
    }

    //retrieve a Tweet
    @GetMapping("/tweet/{tweet_id}")
    public Tweet getTweet(@PathVariable("tweet_id") long tweet_id) {
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        return tweet.get(0);
    }

    //update a tweet
    @Transactional
    @PutMapping("/tweet/{tweet_id}")
    public int updateTweet(@PathVariable("tweet_id") long tweet_id) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return tweetRepository.updateByTweet_id(tweet_id, "new content", timestamp);
    }

    //delete a tweet
    @Transactional
    @DeleteMapping("/tweet/{tweet_id}")
    public int deleteTweet(@PathVariable("tweet_id") long tweet_id) {

        return tweetRepository.deleteByTweet_id(tweet_id);
    }

    //Retweet
    //post a retweet
    @PostMapping("/user/{id}/retweet/{source_tweet_id}")
    public Tweet postRetweet(@PathVariable("id") long id, @PathVariable("source_tweet_id") long source_tweet_id) {
        List<User> user = userRepository.findById(id);
        Tweet tweet = new Tweet();
        tweet.setSource_tweet_id(source_tweet_id);
        tweet.setRetweet_user(user);
        return tweetRepository.save(tweet);
    }

    //delete retweet
    @Transactional
    @DeleteMapping("/user/{id}/retweet/{source_tweet_id}")
    public int deleteRetweet(@PathVariable("id") long id, @PathVariable("source_tweet_id") long source_tweet_id) {
        List<User> user = userRepository.findById(id);
        Tweet tweet = new Tweet();
        tweet.setSource_tweet_id(source_tweet_id);

        return tweetRepository.deleteRetweet(user.get(0), source_tweet_id);
    }

    //Fetch the user who retweet this tweet
    @GetMapping("/tweet/{tweet_id}/retweeted_by")
    public List<User> getRetweetuser(@PathVariable("tweet_id") long tweet_id) {
        return tweetRepository.findRetweetuser(tweet_id);
    }
}
