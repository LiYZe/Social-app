package com.lyztweet.tweet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.models.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class commentController {

    @Autowired
    com.lyztweet.tweet.Repositories.commentRepository commentRepository;
    @Autowired
    com.lyztweet.tweet.Repositories.tweetRepository tweetRepository;
    //Post a Comment
    @PostMapping("/tweet/{tweet_id}/comment/")
    public Comment postComment(@PathVariable("{tweet_id}") long tweet_id) {
        Comment comment = new Comment();
        comment.setComment_content("comment test");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        comment.setTime_stamp(timestamp);
        return commentRepository.save(comment);

    }

    //Delete a Comment
    @DeleteMapping("/tweet/{tweet_id}/comment/{comment_id}")
    public boolean deleteComment(@PathVariable("{tweet_id}") long tweet_id,@PathVariable("{comment_id}") long comment_id) {
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);
        return commentRepository.deleteById(tweet, comment_id);
    }

    //Get all the comment
    @GetMapping("/tweet/{tweet_id}/comment/")
    public List<Comment> getComment(@PathVariable("{tweet_id}") long tweet_id) {
        Tweet tweet = tweetRepository.findtargetTweet(tweet_id);

        return commentRepository.findById(tweet);
    }
}
