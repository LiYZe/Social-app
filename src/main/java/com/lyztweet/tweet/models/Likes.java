package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "likesEntity")
public class Likes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long likes_id;

    @ManyToOne
    @JoinColumn(name = "liked_tweet")
    Tweet liked_tweet;

    @ManyToOne
    @JoinColumn(name = "liking_user")
    User liking_user;

    public void setLiked_tweet(Tweet liked_tweet) {
        this.liked_tweet = liked_tweet;
    }

    public void setLiking_user(User liking_user) {
        this.liking_user = liking_user;
    }

    public Tweet getLiked_tweet() {
        return liked_tweet;
    }

    public User getLiking_user() {
        return liking_user;
    }
}
