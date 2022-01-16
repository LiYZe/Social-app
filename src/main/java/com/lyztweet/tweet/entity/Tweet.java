package com.lyztweet.tweet.entity;

import com.lyztweet.tweet.models.Comment;
import com.lyztweet.tweet.models.Likes;
import com.lyztweet.tweet.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Tweet")
public class Tweet implements Serializable {
    @Id
    private long tweet_id;
    private String content;
    private Timestamp timestamp;
    private long source_tweet_id;
    private List<Comment> comments;
    private List<Likes> liking_user;
    private List<User> retweet_user;
}
