# Tweet_App

## API

### Tweet

#### Tweet

|    |  Method   | URL               | Function                     | Return |
|----|  ----     |-------------------|------------------------------| ----|
|  Create a new Tweet  | POST     | /tweet/           | postTweet()                  | Tweet|
|  Retrieve a Tweet       |  GET     | /tweet/{tweet_id} | getTweet(String tweeet_id)   | Tweet|
|  Update a Tweet      |  PUT     | /tweet/{tweet_id} | updataTweet(String tweet_id) | Tweet|
|  Delete a Tweet      |  DELETE  | /tweet/{tweet_id} | deleteTweet(String tweet_id) | boolean|

#### Comment

|    |  Method   | URL | Function                           | Return |
|----|  ----     |----|------------------------------------|--------|
|  Make a comment      |  POST     | /tweet/{tweet_id}/comment/ | postComment(String tweet_id)| Comment |
|  Delete a commment   |  DELETE   | /tweet/{tweet_id}/comment/ | deleteComment(String tweet_id)     | boolean |

#### Retweet

|    |  Method   | URL | Function | Return |
|----|  ----     |----| ----  |----  |
|  Retweet by a user      |  GET     | /user/{id}/retweet | ser_retweet(String id)| Retweet|

#### Likes

|    |  Method   | URL |Function | Return        |
|----|  ----     |----| ----  |---------------|
|  User like a tweet  |  POST     | /user/{id}/like              | postLike(String id)| boolean       |
|  User undo like  |  DELETE     | /user/{id}/like/{tweet_id}   |undoLike(String id, String tweet_id)| boolean       |
|  Tweet liked by a user   |  GET     | /tweet/{tweet_id}/liking_user | tweet_liking_user(String tweet_id)| LinkedList< User > |
|  User who like a tweet   |  GET     | /user/{id}/liked_tweet       |user_liked_tweet(String id)| LinkedList < User > |

### User

#### User

|    |  Method   | URL | Function| Return |
|----|  ----     |----|----|----  |
|  sign up  |  POST     | /user/   | Sign_Up() | User|
|  sign in       |  GET      | /user/{id} | Sign_In(String ID) | boolean|

#### Follow

|    |  Method   | URL | Function| Return             |
|----|  ----     |----|----|--------------------|
|  follow a user  |  POST     | /user/{id}/following |follow_user(String id)| boolean            |
|  unfollow a user|  DELETE   | /user/{source_user_id}/following/{target_user_id} | unfollow_user(String id, String target_id)| boolean            |
| check following | Get | /user/{id}/following |check_following(String id)| LinkedList< User > |
| Check follower | GET |/user/{id}/follower|check_follower(String id) | LinkedList< User > |




