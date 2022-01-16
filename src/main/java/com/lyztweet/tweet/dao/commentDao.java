package com.lyztweet.tweet.dao;

import com.lyztweet.tweet.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class commentDao {
    public static final String HASH_KEY = "Comment";
    @Autowired
    private RedisTemplate template;

    public Comment save(Comment comment){
        template.opsForHash().put(HASH_KEY,comment.getComment_id(),comment);
        return comment;
    }

    public List<Comment> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Comment findCommentById(long comment_id){
        return (Comment) template.opsForHash().get(HASH_KEY,comment_id);
    }


    public String deleteComment(long comment_id){
        template.opsForHash().delete(HASH_KEY,comment_id);
        return "comment removed !!";
    }
}
