package com.lyztweet.tweet.dao;

import com.lyztweet.tweet.entity.Likes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class likesDao {

    public static final String HASH_KEY = "likes";
    @Autowired
    private RedisTemplate template;

    public Likes save(Likes likes){
        template.opsForHash().put(HASH_KEY,likes.getLikes_id(),likes);
        return likes;
    }

    public List<Likes> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Likes findLikesById(long likes_id){
        return (Likes) template.opsForHash().get(HASH_KEY,likes_id);
    }

    public String deleteLikes(long likes_id){
        template.opsForHash().delete(HASH_KEY,likes_id);
        return "likes removed !!";
    }
}
