package com.lyztweet.tweet.entity;


import com.lyztweet.tweet.models.Tweet;
import com.lyztweet.tweet.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("likesEntity")
public class likesEntity implements Serializable {
    @Id
    private long likes_id;
    Tweet liked_tweet;
    User liking_user;
}
