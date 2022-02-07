package com.lyztweet.tweet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import com.lyztweet.tweet.entity.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("tweet")
public class tweetEntity implements Serializable {
    @Id
    public long tweet_id;
    public String content;
    public Timestamp time_stamp;
    public long source_tweet_id = -1;
    public List<commentEntity> comments;
    public List<likesEntity> liking_user;
    public List<userEntity> retweet_user;

    public List<commentEntity> getComments() {
        return comments;
    }

    public void setComments(List<commentEntity> comments) {
        this.comments = comments;
    }

    public List<likesEntity> getLiking_user() {
        return liking_user;
    }

    public void setLiking_user(List<likesEntity> liking_user) {
        this.liking_user = liking_user;
    }

    public List<userEntity> getRetweet_user() {
        return retweet_user;
    }

    public void setRetweet_user(List<userEntity> retweet_user) {
        this.retweet_user = retweet_user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(Timestamp time_stamp) {
        this.time_stamp = time_stamp;
    }

    public long getSource_tweet_id() {
        return source_tweet_id;
    }

    public void setSource_tweet_id(long source_tweet_id) {
        this.source_tweet_id = source_tweet_id;
    }
}
