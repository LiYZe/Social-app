package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RetweetRepository extends CrudRepository<Retweet, Long> {
    Retweet save(Retweet retweet);
    @Query(value = "select r.retweet_user rom Retweet r where r.retweet_tweet = :retweet")
    List<User> findUserByTweet(@Param("retweet") Tweet tweet);

    @Query(value = "delete from Retweet r where r.retweet_user = :user and r.retweet_tweet = :source_tweet")
    boolean deleteRetweets(@Param("user") User user, @Param("source_tweet") Tweet tweet);
}
