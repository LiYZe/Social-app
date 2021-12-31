package com.lyztweet.tweet.models;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comment_id;

    @Column(name = "comment_content")
    public String Comment_content;

    @ManyToOne
    public User comment_user_id;

    @ManyToOne
    public Tweet comment_tweet_id;

    public Comment() {
    }
}
