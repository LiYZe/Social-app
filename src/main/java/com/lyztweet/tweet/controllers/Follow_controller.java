package com.lyztweet.tweet.controllers;

import com.lyztweet.tweet.Repositories.FollowRepository;
import com.lyztweet.tweet.Repositories.UserRepository;
import com.lyztweet.tweet.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Follow_controller {
    @Autowired
    FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    //follow a user
    @PostMapping("/user/{source_user_id}/following/{target_user_id}")
    public String follow_user(@PathVariable("source_user_id") long id, @PathVariable("target_User_id") long target_id) {
        User user = userRepository.findtargetUser(id);
        User new_following = userRepository.findtargetUser(target_id);

        Follow following = new Follow();
        following.setFollow_user(user);
        following.setFollowing(new_following);
        followRepository.save(following);

        Follow followed = new Follow();
        following.setFollow_user(new_following);
        following.setFollowed(user);
        followRepository.save(followed);

        return "user is followed";
    }

    //unfollow a user
    @DeleteMapping("/user/{source_user_id}/following/{target_user_id}")
    public boolean unfollow_user(@PathVariable("source_user_id") long id, @PathVariable("target_User_id") long target_id) {
        User user = userRepository.findtargetUser(id);
        User following = userRepository.findtargetUser(target_id);

        return followRepository.deleteFollowing(user,following) && followRepository.deleteFollowed(following, user);
    }

    //check following
    @GetMapping("/user/{id}/following")
    public List<Follow> fetch_following(@PathVariable("id") long id) {
        User user = userRepository.findtargetUser(id);
        List<Follow> following = followRepository.findfollowning(user);
        return following;
    }

    //check follower
    @GetMapping("/user/{id}/follower")
    public List<Follow> fetch_follower(@PathVariable("id") long id) {
        User user = userRepository.findtargetUser(id);
        List<Follow> followed = followRepository.findfollowed(user);
        return followed;
    }
}
