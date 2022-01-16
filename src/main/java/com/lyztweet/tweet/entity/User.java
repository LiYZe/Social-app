package com.lyztweet.tweet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("User")
public class User implements Serializable {
    @Id
    private long id;
    private String username;
    private String passwords;
    private List<Follow> followed;
    private List<Follow> followings;
    private List<Comment> comments;
    private List<Likes> liked_tweet;
}
