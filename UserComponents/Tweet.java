package UserComponents;
import java.util.Random;

public class Tweet {
    private String tweet;
    private boolean positive;
    private Random random = new Random();

    public Tweet(String tweet){
        this.tweet = tweet;
        this.positive = random.nextBoolean();
    }
    
    public String getTweet(){
        return this.tweet;
    }
}
