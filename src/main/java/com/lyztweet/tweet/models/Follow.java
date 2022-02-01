package com.lyztweet.tweet.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "followEntity")
public class Follow implements Serializable {
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
