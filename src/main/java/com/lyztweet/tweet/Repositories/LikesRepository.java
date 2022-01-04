package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikesRepository extends CrudRepository<Likes, Long> {

    @Query(value = "delete from Likes l where l.liked_tweet = :tweet and l.liking_user = :user")
    Boolean deleteLikes(@Param("user") User user, @Param("tweet") Tweet tweet);

    @Query(value = "select l.liked_tweet from Likes l where l.liking_user = :user")
    List<Likes> findliked_tweetByUser(@Param("user") User user);

    @Query(value = "select l.liking_user from Likes l where l.liked_tweet = :tweet")
    List<Likes> findLiking_userByTweet(@Param("tweet") Tweet tweet);
}
