package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface tweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findById(long tweetID);
    Tweet save(Tweet new_tweet);

    @Query(value = "delete from Tweet t where t.tweet_id = ?1")
    Boolean deleteByTweet_id(long tweet_id);

    @Query(value = "update Tweet t set t.content = :content, t.time_stamp = :time_stamp")
    Boolean updateByTweet_id(@Param("tweet_id")long tweet_id, @Param("content")String content,@Param("time_stamp") Timestamp time_stamp);

    @Query(value = "select * from Tweet t where t.tweet_id = :tweet_id", nativeQuery = true)
    Tweet findtargetTweet(@Param("tweet_id")long tweet_id);

    //Retweet
    @Query(value = "insert into Tweet(source_tweet_id, retweet_user) value(:user,:source_tweet_id,)",nativeQuery = true)
    Tweet saveRetweet(@Param("user")User user, @Param("source_tweet_id")long source_tweet_id);

    @Query(value = "delete from Tweet t where t.source_tweet_id = :source_tweet_id and t.retweet_user = :user")
    Boolean deleteRetweet(@Param("user")User user, @Param("source_tweet_id")long source_tweet_id);

    @Query(value ="select t.retweet_user from Tweet t where t.source_tweet_id = :tweet_id")
    List<User> findRetweetuser(@Param("tweet_id")long tweet_id);
}

