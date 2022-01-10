package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class likesController {

    @Autowired
    com.lyztweet.tweet.Repositories.userRepository userRepository;

    @Autowired
    com.lyztweet.tweet.Repositories.tweetRepository tweetRepository;

    @Autowired
    com.lyztweet.tweet.Repositories.likesRepository likesRepository;

    //User like a tweet
    @PostMapping("/user/{id}/like/{tweet_id}")
    public boolean postLike(@PathVariable("{id}") long id, @PathVariable("{tweet_id}") long tweet_id) {
        User user = userRepository.findtargetUser(id);
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);
        Likes likes = new Likes();
        likes.setLiked_tweet(tweet);
        likes.setLiking_user(user);

        return likesRepository.save(likes);
    }

    //User undo like
    @DeleteMapping("/user/{id}/like/{tweet_id}")
    public boolean undoLike(@PathVariable("{id}") long id, @PathVariable("{tweet_id}") long tweet_id) {
        User user = userRepository.findtargetUser(id);
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);
        return likesRepository.deleteLikes(user, tweet);
    }

    //User who like a tweet
    @GetMapping("/tweet/{tweet_id}/liking_user")
    public List<User> tweet_liking_user(@PathVariable("{tweet_id}") long tweet_id) {
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);
        List<User> likes = likesRepository.findLiking_userByTweet(tweet);
        return likes;
    }

    //Tweet liked by a user
    @GetMapping("/user/{id}/liked_tweet")
    public List<Tweet> user_liked_tweet(@PathVariable("{id}") long id) {
        User user = userRepository.findtargetUser(id);
        List<Tweet> likes = likesRepository.findliked_tweetByUser(user);
        return likes;
    }
}
