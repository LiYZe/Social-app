package com.lyztweet.tweet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.security.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Comment")
public class Comment implements Serializable {
    @Id
    private int comment_id;
    private String comment_content;
    private Timestamp timestamp;
    private User comment_user;
    private Tweet comment_tweet;
}
