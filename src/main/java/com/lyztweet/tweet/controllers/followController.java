package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
public class followController {
    @Autowired
    com.lyztweet.tweet.Repositories.followRepository followRepository;

    @Autowired
    private com.lyztweet.tweet.Repositories.userRepository userRepository;

    //follow a user
    @PostMapping("/user/{source_user_id}/following/{target_user_id}")
    public boolean follow_user(@PathVariable("source_user_id") long id, @PathVariable("target_user_id") long target_id) {
        List<User> user = userRepository.findById(id);
        List<User> new_following = userRepository.findById(target_id);

        Follow following = new Follow();
        following.setFollow_user(user.get(0));
        following.setFollowing(new_following.get(0));

        Follow followed = new Follow();
        followed.setFollow_user(new_following.get(0));
        followed.setFollowed(user.get(0));

        Follow res_following = followRepository.save(following);
        Follow res_followed = followRepository.save(followed);

        if(res_followed != null && res_following != null){
            return true;
        }

        return false;
    }

    //unfollow a user
    @Transactional
    @DeleteMapping("/user/{source_user_id}/following/{target_user_id}")
    public int unfollow_user(@PathVariable("source_user_id") long id, @PathVariable("target_user_id") long target_id) {
        List<User> user = userRepository.findById(id);
        List<User> following = userRepository.findById(target_id);

        int delete_following = followRepository.deleteFollowing(user.get(0),following.get(0));
        int delete_followed = followRepository.deleteFollowed(following.get(0), user.get(0));

        return  delete_followed + delete_following;
    }

    //check following
    @GetMapping("/user/{id}/following")
    public List<User> fetch_following(@PathVariable("id") long id) {
        List<User> user = userRepository.findById(id);
        List<User> following = followRepository.findfollowning(user.get(0));
        return following;
    }

    //check follower
    @GetMapping("/user/{id}/follower")
    public List<User> fetch_follower(@PathVariable("id") long id) {
        List<User> user = userRepository.findById(id);
        List<User> followed = followRepository.findfollowed(user.get(0));
        return followed;
    }
}
