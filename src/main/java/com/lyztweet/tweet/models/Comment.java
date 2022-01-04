package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comment_id;

    @Column(name = "comment_content")
    public String comment_content;

    @Column(name = "timestamp")
    public Timestamp time_stamp;

    @ManyToOne
    public User comment_user_id;

    @ManyToOne
    public Tweet comment_tweet_id;

    public Comment() {
    }

    public Comment(String comment_content, Timestamp time_stamp) {
        comment_content = comment_content;
        this.time_stamp = time_stamp;
    }
}
