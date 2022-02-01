package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.dao.tweetDao;
import com.lyztweet.tweet.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.entity.*;


import javax.transaction.Transactional;
import java.util.List;

@RestController
public class tweetController {
    @Autowired
    private tweetDao tweetDao;


    //create a new tweetEntity
    @PostMapping("/tweet")
    public Object postTweet(@RequestBody tweetEntity tweetEntity) {
        return tweetDao.save(tweetEntity);
    }

    //retrieve a tweetEntity
    @GetMapping("/tweet/{tweet_id}")
    public Object getTweet(@PathVariable("tweet_id") long tweet_id) {
        return tweetDao.getTweet(tweet_id);
    }

    //update a tweetEntity
    @Transactional
    @PutMapping("/tweet/{tweet_id}")
    public int updateTweet(@PathVariable("tweet_id") long tweet_id, @RequestBody tweetEntity tweetEntity) {
        return tweetDao.updateTweet(tweet_id, tweetEntity);
    }

    //delete a tweet
    @Transactional
    @DeleteMapping("/tweet/{tweet_id}")
    public int deleteTweet(@PathVariable("tweet_id") long tweet_id) {
        return tweetDao.deleteTweet(tweet_id);
    }

    //Retweet
    //post a retweet
    @PostMapping("/user/{id}/retweet/{source_tweet_id}")
    public tweetEntity postRetweet(@PathVariable("id") long id, @PathVariable("source_tweet_id") long source_tweet_id, tweetEntity tweetEntity) {
        return tweetDao.postRetweet(id, source_tweet_id, tweetEntity);
    }

    //delete retweet
    @Transactional
    @DeleteMapping("/user/{id}/retweet/{tweet_id}")
    public int deleteRetweet(@PathVariable("id") long id, @PathVariable("tweet_id") long tweet_id) {
        return tweetDao.deleteTweet(tweet_id);
    }


    //Fetch the user who retweet this tweet
    @GetMapping("/tweet/{tweet_id}/retweeted_by")
    public List<User> getRetweetuser(@PathVariable("tweet_id") long tweet_id) {
        return tweetDao.getRetweetuser(tweet_id);
    }

}
