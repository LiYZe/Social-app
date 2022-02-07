package com.lyztweet.tweet.dao;

import com.lyztweet.tweet.entity.followEntity;
import com.lyztweet.tweet.entity.userEntity;
import com.lyztweet.tweet.entity.tweetEntity;
import com.lyztweet.tweet.models.*;
import com.lyztweet.tweet.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class tweetDao {

    public static final String HASH_KEY = "tweetEntity";
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;
    @Autowired
    userDao userDao;
    @Autowired
    tweetRepository tweetRepository;
    @Autowired
    userRepository userRepository;
    @Autowired
    followRepository followRepository;

    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    public Object save(long id, tweetEntity tweetEntity){

        Tweet tweet = new Tweet();
        tweet.setContent(tweetEntity.getContent());
        tweet.setTime_stamp(timestamp);
        tweetEntity.setTime_stamp(timestamp);
        tweetRepository.save(tweet);
        template.opsForHash().put(HASH_KEY, tweet.getTweet_id(), tweetEntity);

        //write timeline
        userEntity userEntity = (userEntity) template.opsForHash().get(HASH_KEY, id);
        if(userEntity.isVip()){
            List<Long> timeline = userEntity.getTimeline();
            timeline.add(tweet.getTweet_id());
            userEntity.setTimeline(timeline);
        }else{
            List<followEntity> followed = userEntity.getFollowed();
            for(followEntity f: followed){
                userEntity followed_user = f.getFollowed();
                List<Long> timeline = followed_user.getTimeline();
                timeline.add(tweet.getTweet_id());
                followed_user.setTimeline(timeline);
            }
        }
        template.opsForHash().put(HASH_KEY,id,userEntity);
        return tweetEntity;
    }

    public Object getTweet(long tweet_id) {
        List<Tweet> tweet = tweetRepository.findById(tweet_id);
        tweet_id = tweet.get(0).getSource_tweet_id() == -1 ? tweet_id : tweet.get(0).getSource_tweet_id();
        if(template.opsForHash().get(HASH_KEY,tweet_id) != null){
            return (tweetEntity) template.opsForHash().get(HASH_KEY,tweet_id);
        }
        return tweetRepository.findById(tweet_id);
    }

    public int updateTweet(long tweet_id, tweetEntity tweetEntity) {
        Tweet tweet = new Tweet();
        tweet.setTime_stamp(timestamp);
        tweet.setContent(tweetEntity.getContent());
        tweetRepository.updateByTweet_id(tweet_id, tweet.getContent(), tweet.getTime_stamp());

        template.opsForHash().delete(HASH_KEY,tweet_id);
        template.opsForHash().put(HASH_KEY, tweet.getTweet_id(), tweetEntity);
        return 1;
    }

    public int deleteTweet(long tweet_id) {
        tweetRepository.deleteByTweet_id(tweet_id);
        template.opsForHash().delete(HASH_KEY,tweet_id);
        return 1;
    }

    public tweetEntity postRetweet(long id, long source_tweet_id, tweetEntity tweetEntity) {
        List<userEntity> user = new ArrayList<>();
        user.add((userEntity)userDao.findUserById(id));
        tweetEntity.setSource_tweet_id(source_tweet_id);
        tweetEntity.setRetweet_user(user);

        List<User> user_db = userRepository.findById(id);
        Tweet tweet = new Tweet();
        tweet.setRetweet_user(user_db);
        tweet.setSource_tweet_id(source_tweet_id);
        tweet.setContent(tweetEntity.getContent());
        tweetRepository.save(tweet);

        template.opsForHash().put(HASH_KEY, tweet.getTweet_id(), tweetEntity);
        return tweetEntity;
    }


    public List<User> getRetweetuser(long tweet_id) {
        return tweetRepository.findRetweetuser(tweet_id);
    }
}
