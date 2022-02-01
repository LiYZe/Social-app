package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    public String username;

    @Column(name = "passwords")
    public String passwords;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed")
    private List<Follow> followed;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "following")
    private List<Follow> following;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_user")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "liked_tweet")
    private List<Likes> liked_tweet;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswords() {
        return passwords;
    }
}
