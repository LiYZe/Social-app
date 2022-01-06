package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comment_id;

    @Column(name = "comment_content")
    public String comment_content;

    @Column(name = "timestamp")
    public Timestamp time_stamp;

    @ManyToOne
    public User comment_user;

    @ManyToOne
    public Tweet comment_tweet;

    public Comment() {
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public void setTime_stamp(Timestamp time_stamp) {
        this.time_stamp = time_stamp;
    }
}
