package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lyztweet.tweet.dao.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
public class followController {
    @Autowired
    followDao followDao;

    //followEntity a user
    @PostMapping("/user/{source_user_id}/following/{target_user_id}")
    public boolean follow_user(@PathVariable("source_user_id") long id, @PathVariable("target_user_id") long target_id) {
        return followDao.save(id, target_id);
    }

    //unfollow a user
    @Transactional
    @DeleteMapping("/user/{source_user_id}/following/{target_user_id}")
    public int unfollow_user(@PathVariable("source_user_id") long id, @PathVariable("target_user_id") long target_id) {
        return followDao.deleteFollow(id, target_id);
    }

    //check following
    @GetMapping("/user/{id}/following")
    public List<User> fetch_following(@PathVariable("id") long id) {
        return followDao.fetch_following(id);
    }

    //check follower
    @GetMapping("/user/{id}/follower")
    public List<User> fetch_follower(@PathVariable("id") long id) {
        return followDao.fetch_follower(id);
    }
}
