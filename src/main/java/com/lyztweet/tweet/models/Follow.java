package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long follow_id;

    @ManyToOne
    private User follow_user;

    @ManyToOne
    @JoinColumn(name = "followed")
    private User followed;

    @ManyToOne
    @JoinColumn(name = "following")
    private User following;

    public Follow() {
    }

    public void setFollow_user(User follow_user) {
        this.follow_user = follow_user;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public void setFollowing(User following) {
        this.following = following;
    }
}
