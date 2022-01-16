package com.lyztweet.tweet.repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface userRepository extends CrudRepository<User, Long> {
    User save(User new_user);
    List<User> findById(long id);
}
