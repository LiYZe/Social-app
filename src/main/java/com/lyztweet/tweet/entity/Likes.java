package com.lyztweet.tweet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Likes")
public class Likes implements Serializable {
    @Id
    private long likes_id;
    private Tweet Liked_tweet;
    private User liking_user;
}
