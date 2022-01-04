package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.Repositories.LikesRepository;
import com.lyztweet.tweet.Repositories.TweetRepository;
import com.lyztweet.tweet.Repositories.UserRepository;
import com.lyztweet.tweet.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Likes_controller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    LikesRepository likesRepository;

    //User like a tweet
    @PostMapping("/user/{id}/like/{tweet_id}")
    public String postLike(@PathVariable("{id}") long id, @PathVariable("{tweet_id}") long tweet_id) {
        User user = userRepository.findtargetUser(id);
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);
        Likes likes = new Likes();
        likes.setLiked_tweet(tweet);
        likes.setLiking_user(user);
        likesRepository.save(likes);
        return "tweet is liked";
    }

    //User undo like
    @DeleteMapping("/user/{id}/like/{tweet_id}")
    public boolean undoLike(@PathVariable("{id}") long id, @PathVariable("{tweet_id}") long tweet_id) {
        User user = userRepository.findtargetUser(id);
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);
        return likesRepository.deleteLikes(user, tweet);
    }

    //Tweet liked by a user
    @GetMapping("/tweet/{tweet_id}/liking_user")
    public List<Likes> tweet_liking_user(@PathVariable("{tweet_id}") long tweet_id) {
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);
        List<Likes> likes = likesRepository.findLiking_userByTweet(tweet);
        return likes;
    }

    //User who like a tweet
    @GetMapping("/user/{id}/liked_tweet")
    public List<Likes> user_liked_tweet(@PathVariable("{id}") long id) {
        User user = userRepository.findtargetUser(id);
        List<Likes> likes = likesRepository.findliked_tweetByUser(user);
        return likes;
    }
}
