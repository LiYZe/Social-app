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
@RedisHash("Follow")
public class Follow implements Serializable {
    @Id
    private long follow_id;

    private User follow_user;
    private User followed;
    private User following;
}
