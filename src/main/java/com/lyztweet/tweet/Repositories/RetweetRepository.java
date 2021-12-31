package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.repository.CrudRepository;

public interface RetweetRepository extends CrudRepository<Retweet, Long> {

}
