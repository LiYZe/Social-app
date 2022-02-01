package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;
import com.lyztweet.tweet.dao.likesDao;

@RestController
public class likesController {
    @Autowired
    likesDao likesDao;

    //userEntity like a tweet
    @PostMapping("/user/{id}/like/{tweet_id}/")
    public Likes postLike(@PathVariable("id") long id, @PathVariable("tweet_id") long tweet_id) {
        return likesDao.save(id, tweet_id);
    }

    //userEntity undo like
    @Transactional
    @DeleteMapping("/user/{id}/like/{tweet_id}")
    public int undoLike(@PathVariable("id") long id, @PathVariable("tweet_id") long tweet_id) {
        return likesDao.deleteLikes(id, tweet_id);
    }

    //userEntity who like a tweet
    @GetMapping("/tweet/{tweet_id}/liking_user")
    public List<User> tweet_liking_user(@PathVariable("tweet_id") long tweet_id) {
        return likesDao.tweet_liking_user(tweet_id);
    }

    //tweetEntity liked by a user
    @GetMapping("/user/{id}/liked_tweet")
    public List<Tweet> user_liked_tweet(@PathVariable("id") long id) {
        return likesDao.user_liked_tweet(id);
    }
}
