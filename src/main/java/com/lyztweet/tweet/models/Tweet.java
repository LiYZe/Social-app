package com.lyztweet.tweet.models;

public class Tweet {
    private String tweet_id;
    public String content;

    public Tweet() {
    }

    public String getTweet_id() {
        return tweet_id;
    }

    public void setTweet_id(String tweet_id) {
        this.tweet_id = tweet_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
