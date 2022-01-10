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

    @Column(name = "time_stamp")
    public Timestamp time_stamp;

    @Column(name = "source_tweet_id")
    public long source_tweet_id;

    @OneToMany(mappedBy = "comment_tweet", fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_tweet")
    public List<Comment> comments;

    @OneToMany(mappedBy = "liking_user",fetch = FetchType.LAZY)
    @JoinColumn(name = "liking_user")
    public List<Likes> liking_user;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    @JoinColumn(name = "retweet_user")
    public List<User> retweet_user;

    public Tweet(String content, Timestamp time_stamp, long source_tweet_id) {
        this.content = content;
        this.time_stamp = time_stamp;
        this.source_tweet_id = -1;
    }

    public Tweet() {

    }
}
