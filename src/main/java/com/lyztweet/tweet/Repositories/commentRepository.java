package com.lyztweet.tweet.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.lyztweet.tweet.models.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface commentRepository extends CrudRepository<Comment, Long> {
    Comment save(Comment comment);
    @Modifying
    @Query(value = "delete from Comment c where c.comment_id = :comment_id")
    int deleteByComment_id(@Param("comment_id")long comment_id);

    @Query(value = "Select c from Comment c where c.comment_tweet = :tweet")
    List<Comment> findAllByComment_tweet(@Param("tweet") Tweet tweet);

}