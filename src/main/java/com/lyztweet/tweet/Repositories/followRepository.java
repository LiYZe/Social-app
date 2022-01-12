package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface followRepository extends CrudRepository<Follow, Long> {
    Follow save(Follow follow);

    @Modifying
    @Query(value = "delete from Follow f where f.follow_user = :user and f.following = :following")
    int deleteFollowing(@Param("user")User user, @Param("following") User following);

    @Modifying
    @Query(value = "delete from Follow f where f.follow_user = :user and f.followed = :followed")
    int deleteFollowed(@Param("user")User user, @Param("followed") User followed);

    @Query(value = "select f.following from Follow f where f.follow_user = :user")
    List<User> findfollowning(@Param("user") User user);

    @Query(value = "select f.followed from Follow f where f.follow_user = :user")
    List<User> findfollowed(@Param("user")User user);

}
