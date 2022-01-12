package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface tweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findById(long tweetID);
    Tweet save(Tweet new_tweet);

    @Modifying
    @Query(value = "delete from Tweet t where t.tweet_id = ?1")
    int deleteByTweet_id(long tweet_id);

    @Modifying
    @Query(value = "update Tweet t set t.content = :content, t.time_stamp = :time_stamp where t.tweet_id = :tweet_id")
    int updateByTweet_id(@Param("tweet_id")long tweet_id, @Param("content")String content,@Param("time_stamp") Timestamp time_stamp);

    //Retweet

    @Modifying
    @Query(value = "delete from Tweet t where t.source_tweet_id = :source_tweet_id and t.retweet_user = :user")
    int deleteRetweet(@Param("user")User user, @Param("source_tweet_id")long source_tweet_id);

    @Query(value ="select t.retweet_user from Tweet t where t.source_tweet_id = :tweet_id")
    List<User> findRetweetuser(@Param("tweet_id")long tweet_id);
}

