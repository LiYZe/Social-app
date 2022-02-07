package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "timeline")
    private List<Tweet> timeline;

    public void setId(long id) {
        this.id = id;
    }

    public List<Follow> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Follow> followed) {
        this.followed = followed;
    }

    public List<Follow> getFollowing() {
        return following;
    }

    public void setFollowing(List<Follow> following) {
        this.following = following;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Likes> getLiked_tweet() {
        return liked_tweet;
    }

    public void setLiked_tweet(List<Likes> liked_tweet) {
        this.liked_tweet = liked_tweet;
    }

    public List<Tweet> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Tweet> timeline) {
        this.timeline = timeline;
    }

    public User() {
    }

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
