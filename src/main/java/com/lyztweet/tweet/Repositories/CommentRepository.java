package com.lyztweet.tweet.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.lyztweet.tweet.models.*;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> save(Comment comment);
    List<Comment> findById(Long tweet_id, Long comment_id);
    void deleteById(Long tweet_id, Long comment_id);

}