package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    public String username;

    @Column(name = "passwords")
    public String passwords;

    @OneToMany(mappedBy = "Follow")
    private List<Follow> follower;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="comment_user_id")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "liked_tweet")
    private List<Likes> liked_tweet;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "retweet_tweet_id")
    private List<Retweet> retweet_tweet_id;

    public User(String username, String passwords) {
        username = username;
        passwords = passwords;
    }

    public User() {

    }
}
