package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.Repositories.RetweetRepository;
import com.lyztweet.tweet.Repositories.TweetRepository;
import com.lyztweet.tweet.Repositories.UserRepository;
import com.lyztweet.tweet.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Retweet_controller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    RetweetRepository retweetRepository;

    //Retweet by a user
    @PostMapping("/user/{id}/retweet/{tweet_id}")
    public Retweet user_retweet(@PathVariable("{id}") long id, @PathVariable("{tweet_id}") long tweet_id) {
        User user = userRepository.findtargetUser(id);
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);

        Retweet retweet = new Retweet();
        retweet.setRetweet_user(user);
        retweet.setRetweet_tweet(tweet);

        return retweetRepository.save(retweet);
    }

    //fetch the user who retweet this tweet
    @GetMapping("/tweet/{tweet_id}/retweet_by")
    public List<User> get_retweetby(@PathVariable("{tweet_id}") long tweet_id) {
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);
        List<User> user = new ArrayList();
        user = retweetRepository.findUserByTweet(tweet);
        return user;
    }

    //delete retweet
    @DeleteMapping("/user/{id}/retweet/{tweet_id}")
    public boolean delete_retweet(@PathVariable("{id}") long id, @PathVariable("{tweet_id}") long tweet_id) {
        User user = userRepository.findtargetUser(id);
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);
        return retweetRepository.deleteRetweets(user, tweet);
    }
}
