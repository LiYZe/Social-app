package com.lyztweet.tweet.dao;

import com.lyztweet.tweet.models.Follow;
import com.lyztweet.tweet.models.User;

import com.lyztweet.tweet.repositories.followRepository;
import com.lyztweet.tweet.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class followDao {

    @Autowired
    followRepository followRepository;
    @Autowired
    userRepository userRepository;
    public boolean save(long id, long target_id) {
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

    public List<User> fetch_following(long id) {
        List<User> user = userRepository.findById(id);
        List<User> following = followRepository.findfollowning(user.get(0));
        return following;
    }

    public List<User> fetch_follower(long id) {
        List<User> user = userRepository.findById(id);
        List<User> followed = followRepository.findfollowed(user.get(0));
        return followed;
    }

    public int deleteFollow(long id, long target_id) {
        List<User> user = userRepository.findById(id);
        List<User> following = userRepository.findById(target_id);

        int delete_following = followRepository.deleteFollowing(user.get(0),following.get(0));
        int delete_followed = followRepository.deleteFollowed(following.get(0), user.get(0));
        return  delete_followed + delete_following;
    }
}
