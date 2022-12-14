package UserComponents;
import java.util.Random;

/*
 * A Tweet contains a String of the actual tweet,
 * and a randomly generated positivity boolean
 */
public class Tweet {
    private String tweet;
    private boolean positive;
    //private Random random = new Random();

    public Tweet(String tweet){
        this.tweet = tweet;
        this.positive = false;
        String temp = tweet.toLowerCase();
        //check if the tweet contains a positive word
        for(String str: PositiveDict.getPositiveDictInstance().getDict()){
            if(temp.contains(str)){
                this.positive = true;
                return;
            }
        }
        System.out.println(this.positive);
    }

    public boolean getPositive(){
        return this.positive;
    }
    
    public String getTweet(){
        return this.tweet;
    }
}
