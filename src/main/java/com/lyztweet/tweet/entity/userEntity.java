package com.lyztweet.tweet.entity;

import com.lyztweet.tweet.models.Comment;
import com.lyztweet.tweet.models.Follow;
import com.lyztweet.tweet.models.Likes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("user")
public class userEntity implements Serializable {
    @Id
    private long id;
    public String username;
    public String passwords;
    public boolean vip;
    private List<followEntity> followed;
    private List<followEntity> following;
    private List<commentEntity> comments;
    private List<likesEntity> liked_tweet;
    private List<Long> timeline;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public List<followEntity> getFollowed() {
        return followed;
    }

    public void setFollowed(List<followEntity> followed) {
        this.followed = followed;
    }

    public List<followEntity> getFollowing() {
        return following;
    }

    public void setFollowing(List<followEntity> following) {
        this.following = following;
    }

    public List<commentEntity> getComments() {
        return comments;
    }

    public void setComments(List<commentEntity> comments) {
        this.comments = comments;
    }

    public List<likesEntity> getLiked_tweet() {
        return liked_tweet;
    }

    public void setLiked_tweet(List<likesEntity> liked_tweet) {
        this.liked_tweet = liked_tweet;
    }

    public List<Long> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Long> timeline) {
        this.timeline = timeline;
    }
}
