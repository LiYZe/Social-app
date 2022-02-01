package com.lyztweet.tweet.entity;

import com.lyztweet.tweet.models.Comment;
import com.lyztweet.tweet.models.Follow;
import com.lyztweet.tweet.models.Likes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("user")
public class userEntity implements Serializable {
    @Id
    private long id;
    public String username;
    public String passwords;
    private List<Follow> followed;
    private List<Follow> following;
    private List<Comment> comments;
    private List<Likes> liked_tweet;
}
