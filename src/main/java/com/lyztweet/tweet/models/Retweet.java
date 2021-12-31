package com.lyztweet.tweet.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Retweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long retweet_id;

    @ManyToOne
    private Tweet retweet_tweetid;

    @ManyToOne
    private User retweet_userid;

    public Retweet() {
    }
}
