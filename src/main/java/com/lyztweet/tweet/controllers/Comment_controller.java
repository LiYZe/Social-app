package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class Comment_controller {

    @Autowired
    CommentRepository commentRepository;
    //Post a Comment
    @PostMapping("/tweet/{tweet_id}/comment/")
    public String postComment(@PathVariable("{tweet_id}") long tweet_id) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        commentRepository.save(new Comment("comment test", timestamp));
        return "make a comment";
    }

    //Delete a Comment
    @DeleteMapping("/tweet/{tweet_id}/comment/{comment_id}")
    public String deleteComment(@PathVariable("{tweet_id}") long tweet_id,@PathVariable("{comment_id}") long comment_id) {
        commentRepository.deleteById(tweet_id, comment_id);
        return "comment is deleted";
    }

    @GetMapping("/tweet/{tweet_id}/comment/{comment_id}")
    public List<Comment> getComment(@PathVariable("{tweet_id}") long tweet_id,@PathVariable("{comment_id}") long comment_id) {
        return commentRepository.findById(tweet_id,comment_id);
    }
}
