package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long likes_id;

    @ManyToOne
    @JoinColumn(name = "liked_tweet")
    Tweet liked_tweet;

    @ManyToOne
    @JoinColumn(name = "liking_user")
    User liking_user;

    public Likes() {
    }
}
