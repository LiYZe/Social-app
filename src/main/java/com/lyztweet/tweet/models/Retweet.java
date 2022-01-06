package com.lyztweet.tweet.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "retweet")
public class Retweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long retweet_id;

    @ManyToOne
    @JoinColumn(name = "retweet_tweet")
    private Tweet retweet_tweet;

    @ManyToOne
    @JoinColumn(name = "retweet_user")
    private User retweet_user;

    public Retweet() {
    }

    public void setRetweet_tweet(Tweet retweet_tweet) {
        this.retweet_tweet = retweet_tweet;
    }

    public void setRetweet_user(User retweet_user) {
        this.retweet_user = retweet_user;
    }
}
