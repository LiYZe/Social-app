package com.lyztweet.tweet.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.lyztweet.tweet.models.*;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}