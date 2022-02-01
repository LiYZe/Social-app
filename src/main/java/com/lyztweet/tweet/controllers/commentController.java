package com.lyztweet.tweet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;
import com.lyztweet.tweet.dao.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class commentController {

    @Autowired
    commentDao commentDao;

    //Post a commentEntity
    @PostMapping("/tweet/{tweet_id}/comment/")
    public Comment postComment(@PathVariable("tweet_id") long tweet_id) {
        return commentDao.save(tweet_id);
    }

    //Delete a commentEntity
    @Transactional
    @DeleteMapping("/comment/{comment_id}")
    public int deleteComment(@PathVariable("comment_id") long comment_id) {
        return commentDao.deleteComment(comment_id);
    }

    //Get all the commentEntity
    @GetMapping("/tweet/{tweet_id}/comment/")
    public List<Comment> getComment(@PathVariable("tweet_id") long tweet_id) {
        return commentDao.findCommentById(tweet_id);
    }
}
