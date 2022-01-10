package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface followRepository extends CrudRepository<Follow, Long> {
    @Query(value = "insert into Follow(follow_user, following) value(:user, :following)", nativeQuery = true)
    boolean savefollowing(@Param("user")User user, @Param("following") User following);

    @Query(value = "insert into Follow(follow_user, followed) value(:user, :followed)", nativeQuery = true)
    boolean savefollowed(@Param("user")User user, @Param("followed") User followed);

    @Query(value = "delete from Follow f where f.follow_user = :user and f.following = :following")
    boolean deleteFollowing(@Param("user")User user, @Param("following") User following);

    @Query(value = "delete from Follow f where f.follow_user = :user and f.followed = :followed")
    boolean deleteFollowed(@Param("user")User user, @Param("followed") User followed);

    @Query(value = "select f.following from Follow f where f.follow_user = :user")
    List<User> findfollowning(@Param("user") User user);

    @Query(value = "select f.followed from Follow f where f.follow_user = :user")
    List<User> findfollowed(@Param("user")User user);

}
