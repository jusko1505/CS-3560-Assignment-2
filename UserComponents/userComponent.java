package UserComponents;

import java.util.List;
public abstract class userComponent {
    public List<userComponent> getUserComponents(userComponent uc){
        throw new UnsupportedOperationException();
    }
    public String getID(){
        throw new UnsupportedOperationException();
    }
    public List<String> getTweets(){
        throw new UnsupportedOperationException();
    }
    public String getName(){
        throw new UnsupportedOperationException();
    }
    public void addObserver(Observer ob){
        throw new UnsupportedOperationException();
    }
}
