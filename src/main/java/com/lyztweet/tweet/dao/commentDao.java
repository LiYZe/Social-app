package com.lyztweet.tweet.dao;

import com.lyztweet.tweet.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lyztweet.tweet.repositories.*;
import com.lyztweet.tweet.models.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class commentDao {
    @Autowired
    commentRepository commentRepository;
    @Autowired
    tweetRepository tweetRepository;

    public Comment save(long tweet_id){
        Comment comment = new Comment();
        comment.setComment_content("comment test");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        comment.setTime_stamp(timestamp);
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        comment.setComment_tweet(tweet.get(0));
        return commentRepository.save(comment);
    }

    public int deleteComment(long comment_id){
        return commentRepository.deleteByComment_id(comment_id);
    }

    public List<Comment> findCommentById(long tweet_id){
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        return commentRepository.findAllByComment_tweet(tweet.get(0));
    }
}
