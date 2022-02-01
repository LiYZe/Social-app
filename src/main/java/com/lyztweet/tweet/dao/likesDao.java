package com.lyztweet.tweet.dao;

import com.lyztweet.tweet.models.Likes;
import com.lyztweet.tweet.models.Tweet;
import com.lyztweet.tweet.models.User;
import com.lyztweet.tweet.repositories.likesRepository;
import com.lyztweet.tweet.repositories.tweetRepository;
import com.lyztweet.tweet.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class likesDao {

    @Autowired
    userRepository userRepository;
    @Autowired
    tweetRepository tweetRepository;
    @Autowired
    likesRepository likesRepository;

    public Likes save(long id, long tweet_id) {
        List<User> user = userRepository.findById(id);
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        Likes likes = new Likes();
        likes.setLiked_tweet(tweet.get(0));
        likes.setLiking_user(user.get(0));
        return likesRepository.save(likes);
    }

    public List<Tweet> user_liked_tweet( long id) {
        List<User> user = userRepository.findById(id);
        List<Tweet> likes = likesRepository.findliked_tweetByUser(user.get(0));
        return likes;
    }

    public List<User> tweet_liking_user(long tweet_id) {
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        List<User> likes = likesRepository.findLiking_userByTweet(tweet.get(0));
        return likes;
    }

    public int deleteLikes(long id, long tweet_id) {
        List<User> user = userRepository.findById(id);
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        return likesRepository.deleteLikes(user.get(0), tweet.get(0));
    }
}
