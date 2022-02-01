package com.lyztweet.tweet.dao;


import com.lyztweet.tweet.entity.userEntity;
import com.lyztweet.tweet.repositories.*;
import com.lyztweet.tweet.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class userDao {
    public static final String HASH_KEY = "tweetEntity";
    @Autowired
    private RedisTemplate template;
    @Autowired
    userRepository userRepository;

    public userEntity save(userEntity user){
        User user_db = new User();
        user_db.setUsername(user.getUsername());
        user_db.setPasswords(user.getPasswords());
        userRepository.save(user_db);

        template.opsForHash().put(HASH_KEY,user_db.getId(),user);
        return user;
    }

    public Object findUserById(long id){
        if(template.opsForHash().get(HASH_KEY,id) != null){
            return (userEntity) template.opsForHash().get(HASH_KEY,id);
        }
        return userRepository.findById(id);
    }

}
