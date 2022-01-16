package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
public class likesController {

    @Autowired
    com.lyztweet.tweet.repositories.userRepository userRepository;

    @Autowired
    com.lyztweet.tweet.repositories.tweetRepository tweetRepository;

    @Autowired
    com.lyztweet.tweet.repositories.likesRepository likesRepository;

    //User like a tweet

    @PostMapping("/user/{id}/like/{tweet_id}/")
    public Likes postLike(@PathVariable("id") long id, @PathVariable("tweet_id") long tweet_id) {
        List<User> user = userRepository.findById(id);
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        Likes likes = new Likes();
        likes.setLiked_tweet(tweet.get(0));
        likes.setLiking_user(user.get(0));
        return likesRepository.save(likes);
    }

    //User undo like
    @Transactional
    @DeleteMapping("/user/{id}/like/{tweet_id}")
    public int undoLike(@PathVariable("id") long id, @PathVariable("tweet_id") long tweet_id) {
        List<User> user = userRepository.findById(id);
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        return likesRepository.deleteLikes(user.get(0), tweet.get(0));
    }

    //User who like a tweet
    @GetMapping("/tweet/{tweet_id}/liking_user")
    public List<User> tweet_liking_user(@PathVariable("tweet_id") long tweet_id) {
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        List<User> likes = likesRepository.findLiking_userByTweet(tweet.get(0));
        return likes;
    }

    //Tweet liked by a user
    @GetMapping("/user/{id}/liked_tweet")
    public List<Tweet> user_liked_tweet(@PathVariable("id") long id) {
        List<User> user = userRepository.findById(id);
        List<Tweet> likes = likesRepository.findliked_tweetByUser(user.get(0));
        return likes;
    }
}
