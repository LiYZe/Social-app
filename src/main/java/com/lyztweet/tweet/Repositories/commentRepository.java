package com.lyztweet.tweet.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.lyztweet.tweet.models.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface commentRepository extends CrudRepository<Comment, Long> {
    Comment save(Comment comment);
    @Query(value = "select * from Comment c where c.comment_tweet = :tweet", nativeQuery = true)
    List<Comment> findById(@Param("tweet") Tweet tweet);

    @Query(value = "delete from Comment c where c.comment_tweet = :tweet and  c.comment_id = :comment_id")
    boolean deleteById(@Param("tweet")Tweet tweet,@Param("comment_id") long comment_id);

}