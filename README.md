# Tweet_App

## API

### Tweet

#### Tweet

|                    | Method | URL               | Function                   | Return |
|--------------------|--------|-------------------|----------------------------|--------|
| Create a new Tweet | POST   | /tweet/           | postTweet()                | String |
| Retrieve a Tweet   | GET    | /tweet/{tweet_id} | getTweet(long tweet_id)    | Tweet  |
| Update a Tweet     | PUT    | /tweet/{tweet_id} | updateTweet(long tweet_id) | String |
| Delete a Tweet     | DELETE | /tweet/{tweet_id} | deleteTweet(long tweet_id) | String |

#### Comment

|                   | Method | URL                                    | Function                                      | Return          |
|-------------------|--------|----------------------------------------|-----------------------------------------------|-----------------|
| Make a comment    | POST   | /tweet/{tweet_id}/comment/             | postComment(long tweet_id)                    | String          |
| Delete a comment  | DELETE | /tweet/{tweet_id}/comment/{comment_id} | deleteComment(long tweet_id, long comment_id) | String          |
| Get a comment     | GET    | /tweet/{tweet_id}/comment/{comment_id} | getComment(long tweet_id, long comment_id)    | List< Comment > |


#### Retweet

|                   | Method   | URL                | Function             | Return  |
|-------------------|----------|--------------------|----------------------|---------|
| Retweet by a user | GET      | /user/{id}/retweet | ser_retweet(long id) | Retweet |

#### Likes

|                       | Method    | URL                           | Function                         | Return         |
|-----------------------|-----------|-------------------------------|----------------------------------|----------------|
| User like a tweet     | POST      | /user/{id}/like/{tweet_id}    | postLike(long id, long tweet_id) | String         |
| User undo like        | DELETE    | /user/{id}/like/{tweet_id}    | undoLike(long id, long tweet_id) | boolean        |
| Tweet liked by a user | GET       | /tweet/{tweet_id}/liking_user | tweet_liking_user(long tweet_id) | List< Likes >  |
| User who like a tweet | GET       | /user/{id}/liked_tweet        | user_liked_tweet(long id)        | List < Likes > |

### User

#### User

|         | Method | URL        | Function         | Return       |
|---------|--------|------------|------------------|--------------|
| sign up | POST   | /user/     | Sign_Up()        | String       |
| sign in | GET    | /user/{id} | Sign_In(long ID) | List< User > |

#### Follow

|                 | Method | URL                                               | Function                               | Return         |
|-----------------|--------|---------------------------------------------------|----------------------------------------|----------------|
| follow a user   | POST   | /user/{source_user_id}/following/{target_user_id} | follow_user(long id, long target_id)   | String         |
| unfollow a user | DELETE | /user/{source_user_id}/following/{target_user_id} | unfollow_user(long id, long target_id) | boolean        |
| check following | Get    | /user/{id}/following                              | fetch_following(long id)               | List< Follow > |
| Check follower  | GET    | /user/{id}/follower                               | fetch_follower(long id)                | List< Follow > |

## Entity

### Tweet

| Key | Type            | Column          |
|-----|-----------------|-----------------|
| PK  | long            | tweet_id        |
|     | String          | content         |
|     | Timestamp       | time_line       |
|     | List< Comment > | comments        |
|     | List< Likes >   | liking_user     |
|     | List< Retweet > | retweet_user_id |

### Comment

| Key | Type      | Column           |
|-----|-----------|------------------|
| PK  | long      | comment_id       |
|     | String    | comment_content  |
|     | Timestamp | time_line        |
| FK  | Tweet     | comment_tweet_id |
| FK  | User      | comment_user_id  |

### Retweet

| Key | Type  | Column          |
|-----|-------|-----------------|
| PK  | long  | retweet_id      |
|     | Tweet | retweet_tweetid |
|     | User  | retweeet_userid |

### User

| Key | Type            | Column           |
|-----|-----------------|------------------|
| PK  | long            | id               |
|     | String          | username         |
|     | String          | passwords        |
|     | List< Follow >  | follower         |
|     | List< Comment > | comment          |
|     | List< Likes >   | likes_tweet      |
|     | List< Retweet > | retweet_tweet_id |

### Follow

| Key | Type | Column      |
|-----|------|-------------|
| PK  | long | follow_id   |
| FK  | User | follow_user |
| FK  | User | followed    |
| FK  | User | following   |

### Likes

| Key | Type  | Column      |
|-----|-------|-------------|
| PK  | long  | likes_id    |
| FK  | Tweet | liked_tweet |
| FK  | User  | liking_user |
