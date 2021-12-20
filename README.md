# Tweet_App

## API

### Tweet

#### Create a new Tweet

|  Method   | url  | function |
|  ----     | ----  | ---- |
| POST      | /tweet/ | postTweet(Integer tweetID, String tweetcontent)|

#### Check a Tweet

|  Method   | url  |function |
|  ----     | ----  |  ----  |
|  GET     | /tweet/{tweet_id}| getTweet(Integer tweetId)|

#### Update a Tweet

|  Method   | url  |function |
|  ----     | ----  |  ----  |
|  PUT     | /tweet/{tweet_id}| updateTweet(Integer tweetId, String tweetcontent)|

#### Delete a Tweet

|  Method   | url  |function |
|  ----     | ----  |  ----  |
|  DELETE     | /tweet/{tweet_id}| deleteTweet(Integer tweetId)|

#### Make a comment

|  Method   | url  |function |
|  ----     | ----  |  ----  |
|  POST     | /tweet/comment/| postComment(Integer tweetId, String comment)|

#### Delete a commment

|  Method   | url  |function |
|  ----     | ----  |  ----  |
|  DELETE     | /tweet/comment/{tweet_id}| deleteComment(Integer tweetId)|

#### Retweet



