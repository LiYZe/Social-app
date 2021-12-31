package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface UserRepository extends CrudRepository<User, Serializable> {

}
