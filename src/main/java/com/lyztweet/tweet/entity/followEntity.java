package com.lyztweet.tweet.entity;

import com.lyztweet.tweet.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("followEntity")
public class followEntity implements Serializable {
    @Id
    private long follow_id;
    private userEntity follow_user;
    private userEntity followed;
    private userEntity following;

    public long getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(long follow_id) {
        this.follow_id = follow_id;
    }

    public userEntity getFollow_user() {
        return follow_user;
    }

    public void setFollow_user(userEntity follow_user) {
        this.follow_user = follow_user;
    }

    public userEntity getFollowed() {
        return followed;
    }

    public void setFollowed(userEntity followed) {
        this.followed = followed;
    }

    public userEntity getFollowing() {
        return following;
    }

    public void setFollowing(userEntity following) {
        this.following = following;
    }
}
