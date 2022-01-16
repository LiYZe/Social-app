package com.lyztweet.tweet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class commentController {

    @Autowired
    com.lyztweet.tweet.repositories.commentRepository commentRepository;
    @Autowired
    com.lyztweet.tweet.repositories.tweetRepository tweetRepository;

    //Post a Comment
    @PostMapping("/tweet/{tweet_id}/comment/")
    public Comment postComment(@PathVariable("tweet_id") long tweet_id) {
        Comment comment = new Comment();
        comment.setComment_content("comment test");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        comment.setTime_stamp(timestamp);
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        comment.setComment_tweet(tweet.get(0));
        return commentRepository.save(comment);

    }

    //Delete a Comment
    @Transactional
    @DeleteMapping("/comment/{comment_id}")
    public int deleteComment(@PathVariable("comment_id") long comment_id) {
        return commentRepository.deleteByComment_id(comment_id);
    }

    //Get all the comment
    @GetMapping("/tweet/{tweet_id}/comment/")
    public List<Comment> getComment(@PathVariable("tweet_id") long tweet_id) {
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        return commentRepository.findAllByComment_tweet(tweet.get(0));
    }
}
