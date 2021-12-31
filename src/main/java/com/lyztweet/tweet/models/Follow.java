package com.lyztweet.tweet.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long follow_id;

    @ManyToOne
    @JoinColumn(name = "followed")
    private User followed;

    @ManyToOne
    @JoinColumn(name = "following")
    private User following;

    public Follow() {
    }
}
