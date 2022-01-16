package com.lyztweet.tweet.dao;

import com.lyztweet.tweet.entity.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class followDao {
    public static final String HASH_KEY = "follow";
    @Autowired
    private RedisTemplate template;

    public Follow save(Follow follow){
        template.opsForHash().put(HASH_KEY,follow.getFollow_id(),follow);
        return follow;
    }

    public List<Follow> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Follow findFollowById(long follow_id){
        return (Follow) template.opsForHash().get(HASH_KEY,follow_id);
    }

    public String deleteFollow(long follow_id){
        template.opsForHash().delete(HASH_KEY,follow_id);
        return "follow removed !!";
    }
}
