import java.util.*;
// the data class for user
public class User implements userInterface, Visitable, Observable, Observer{
    private int ID;
    private List<Integer> followers;
    private List<Integer> following;
    private List<String> newsFeed;
    private List<String> myTweets;
    private List<Observer> observers;

    public User() {
        this.ID = Integer.parseInt(UUID.randomUUID().toString());
    }

    @Override
    public void addObserver(Observer ob) {
        if(observers==null){
            observers = new ArrayList<Observer>();
        }
        observers.add(ob);
        // TODO Auto-generated method stub
    }

    public List<Observer> getObservers(){
        if(observers==null){
            return null;
        }
        return this.observers;
    }
    
    @Override
    public void update(){
        System.out.println("You have a notification!");
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
        
    }
    public List<String> getMyTweets(){
        return myTweets;
    }

    public void setFollowers(List<Integer> list){
        this.followers = list;
    }
    @Override
    public List<Integer> getFollowers() {
        return this.followers;
        
    }

    @Override
    public List<Integer> getFollowing() {
        // TODO Auto-generated method stub
        return this.following;
    }

    @Override
    public int getID() {
        // TODO Auto-generated method stub
        return this.ID;
    }

    @Override
    public List<String> getNewsFeed() {
        // TODO Auto-generated method stub
        return this.newsFeed;
    }
    
}
