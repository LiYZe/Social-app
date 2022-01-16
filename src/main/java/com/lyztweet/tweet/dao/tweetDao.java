package com.lyztweet.tweet.dao;

import com.lyztweet.tweet.entity.Comment;
import com.lyztweet.tweet.entity.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class tweetDao {
    public static final String HASH_KEY = "Tweet";
    @Autowired
    private RedisTemplate template;

    public Tweet save(Tweet tweet){
        template.opsForHash().put(HASH_KEY,tweet.getTweet_id(),tweet);
        return tweet;
    }

    public List<Tweet> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Tweet findTweetById(int tweet_id){
        return (Tweet) template.opsForHash().get(HASH_KEY,tweet_id);
    }


    public String deleteTweet(int tweet_id){
        template.opsForHash().delete(HASH_KEY,tweet_id);
        return "tweet removed !!";
    }
}
