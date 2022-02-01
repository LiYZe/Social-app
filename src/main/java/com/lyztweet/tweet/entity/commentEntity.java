package com.lyztweet.tweet.entity;


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
@RedisHash("followEntity")
public class commentEntity implements Serializable {
    @Id
    private long follow_id;
    private User follow_user;
    private User followed;
    private User following;
}
