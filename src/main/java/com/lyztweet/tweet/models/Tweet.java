package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "tweet")
public class Tweet implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long tweet_id;

    @Column(name = "content")
    public String content;

    @Column(name = "time_line")
    public Timestamp time_line;

    @OneToMany(mappedBy = "comment_tweet", fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_tweet")
    public List<Comment> comments;

    @OneToMany(mappedBy = "liking_user",fetch = FetchType.LAZY)
    @JoinColumn(name = "liking_user")
    public List<Likes> liking_user;

    @OneToMany(mappedBy = "retweet_user",fetch = FetchType.LAZY)
    @JoinColumn(name = "retweet_user")
    public List<Retweet> retweet_user_id;

    public Tweet(String content, Timestamp time_line) {
        this.content = content;
        this.time_line = time_line;
    }

    public Tweet() {

    }
}
