package com.lyztweet.tweet.dao;


import com.lyztweet.tweet.entity.followEntity;
import com.lyztweet.tweet.entity.userEntity;
import com.lyztweet.tweet.repositories.*;
import com.lyztweet.tweet.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class userDao {
    public static final String HASH_KEY = "User";
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

//    public userEntity save(userEntity user){
//        template.opsForHash().put(HASH_KEY,user.getId(),user);
//        return user;
//    }
//
//    public List<User> findAll(){
//        return template.opsForHash().values(HASH_KEY);
//    }
//
//    public userEntity findUserById(long id){
//        return (userEntity) template.opsForHash().get(HASH_KEY,id);
//    }
//
//    public String deleteUser(long id){
//        template.opsForHash().delete(HASH_KEY,id);
//        return "User removed !!";
//    }

    @Autowired
    userRepository userRepository;

    public userEntity save(userEntity user){
        User user_db = new User();
        user_db.setUsername(user.getUsername());
        user_db.setPasswords(user.getPasswords());
        userRepository.save(user_db);
        long user_id = userRepository.findId(user_db.username);
        template.opsForHash().put(HASH_KEY,user_id,user);
        return user;
    }

    public Object findUserById(long id) {
        if (template.opsForHash().get(HASH_KEY, id) != null) {
            return (userEntity) template.opsForHash().get(HASH_KEY, id);
        }
        return userRepository.findById(id);
    }
    public List<Long> readTimeline(long id){
        userEntity userEntity = (userEntity) template.opsForHash().get(HASH_KEY, id);
        List<Long> timeline = userEntity.getTimeline();
        List<followEntity> following = userEntity.getFollowing();
        for(followEntity f : following) {
            userEntity user_following = f.getFollowing();
            List<Long> user_Following_timeline = user_following.getTimeline();
            for (long l : user_Following_timeline) {
                timeline.add(l);
            }
        }
        Collections.sort(timeline);
        userEntity.setTimeline(timeline);
        template.opsForHash().put(HASH_KEY,id,userEntity);
        return timeline;
    }

}
