package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.Tweet;
import org.springframework.data.repository.CrudRepository;

public interface TweetRepository extends CrudRepository<Tweet, Long> {

}

