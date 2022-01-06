package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.Tweet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface TweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findById(long tweetID);
    Tweet save(Tweet new_tweet);

    @Query(value = "delete from Tweet t where t.tweet_id = ?1")
    Boolean deleteByTweet_id(long tweet_id);

    @Query(value = "update Tweet t set t.content = :content, t.time_line = :time_line")
    Boolean updateByTweet_id(@Param("tweet_id")long tweet_id, @Param("content")String content,@Param("time_line") Timestamp time_line);

    @Query(value = "select * from Tweet t where t.tweet_id = :tweet_id", nativeQuery = true)
    Tweet findtargetTweet(@Param("tweet_id")long tweet_id);
}

