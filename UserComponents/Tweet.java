package UserComponents;
public class Tweet {
    private String tweet;
    private boolean positive;

    public Tweet(String tweet, boolean positive){
        this.tweet = tweet;
        this.positive = positive;
    }
    
    public String getTweet(){
        return this.tweet;
    }
}
