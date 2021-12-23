# Tweet_App

## API

### Tweet

#### Tweet

|    |  Method   | url  |
|----|  ----     | ----  | 
|  Create a new Tweet  | POST     | /tweet/  | 
|  Check a Tweet       |  GET     | /tweet/{tweet_id} | 
|  Update a Tweet      |  PUT     | /tweet/{tweet_id} | 
|  Delete a Tweet      |  DELETE  | /tweet/{tweet_id} | 

#### Comment

|    |  Method   | url  |
|----|  ----     | ----  | 
|  Make a comment      |  POST     | /tweet/{tweet_id}/comment/ |
|  Delete a commment   |  DELETE   | /tweet/{tweet_id}/comment/ |
#### Retweet

|    |  Method   | url  | 
|----|  ----     | ----  | 
|  Retweet by a user      |  GET     | /user/{id}/retweet |

#### Likes

|    |  Method   | url  | 
|----|  ----     | ----  |
|  User like a tweet  |  POST     | /user/{id}/like | 
|  User undo like  |  DELETE     | /user/{id}/like/{tweet_id} |
|  Tweet liked by a user   |  GET     | /tweet/{tweet_id}/liking_user | 
|  User who like a tweet   |  GET     | /user/{id}/liked_tweet |

### User

#### User

|    |  Method   | url  | 
|----|  ----     | ----  |
|  sign up  |  POST     | /user/ |
|  sign in       |  GET      | /user/ | 

#### Follow

|    |  Method   | url  | 
|----|  ----     | ----  | 
|  follow a user  |  POST     | /user/{id}/following |
|  unfollow a user|  DELETE   | /user/{source_user_id}/following/{target_user_id} | 
| check following | Get | /user/{id}/following |
| Check follower | GET |/user/{id}/follower|




