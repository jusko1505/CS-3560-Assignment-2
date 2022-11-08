package UserComponents;
import java.util.*;
// the data class for user
public class User extends userComponent implements  userInterface, Visitable, Observable, Observer{
    private String ID;
    private String name;
    //private HashSet<String> uniqueFollowing;
    private List<String> followers;
    private List<String> following;
    private List<String> followingName;
    private List<String> newsFeed;
    private List<String> myTweets;
    private List<Observer> observers;

    public User(String name) {
        this.ID = UUID.randomUUID().toString();
        this.name = name;
        this.followers = new ArrayList<String>();
        this.following = new ArrayList<String>();
        this.newsFeed = new ArrayList<String>();
        this.myTweets= new ArrayList<String>();
        this.followingName = new ArrayList<String>();
        System.out.println("news feed: "+ newsFeed.size());
        System.out.println("mytweets: "+ myTweets.size());
    }

    public List<String> getFollowingName(){
        return this.followingName;
    }

    public void updateNewsFeed(){
        newsFeed = new ArrayList<String>();
        for(String UUID: following){
            for (userComponent uc : userRoot.getUserRoot().getUserRootList()){
                if(UUID.equals(uc.getID())){
                    for(String tweet: uc.getTweets()){
                        newsFeed.add(uc.getName()+": "+tweet);
                    }
                }
            }
        }
    }

    public void follow(String UUID){
        for(userComponent uc : userRoot.getUserRoot().getUserRootList()){
            if(uc.getID().equals(UUID)){
                following.add(UUID);
                followingName.add(uc.getName());
                uc.addObserver((Observer)this);
                System.out.println("followed "+ UUID);
                return;
            }
        }
        System.out.println("failed to follow "+ UUID);
    }

    public String getName(){
        return this.name;
    }

    @Override
    public List<userComponent> getUserComponents(userComponent uc) {
        ArrayList<userComponent> leaf = new ArrayList<userComponent>();
        return leaf;
    }

    public void Tweet(String myTweet, Visitor v){
        myTweets.add(myTweet);
        accept(v);
        userRoot.getUserRoot().setNumberOfMessages(userRoot.getUserRoot().getNumberOfMessages()+1);
        System.out.println("successfully tweeted out");
    }

    @Override
    public void addObserver(Observer ob) {
        if(observers==null){
            observers = new ArrayList<Observer>();
        }
        observers.add(ob);
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
    public List<String> getTweets(){
        return myTweets;
    }

    public void setFollowers(List<String> list){
        this.followers = list;
    }
    @Override
    public List<String> getFollowers() {
        return this.followers;
        
    }

    @Override
    public List<String> getFollowing() {
        if(following.size()==0){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add("You are not following anyone");
            return temp;
        }
        return this.following;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public List<String> getNewsFeed() {
        updateNewsFeed();
        if(newsFeed.size()==0){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add("No news yet");
            return temp;
        }
        return this.newsFeed;
    }

    public String toString(){
        return name;
    }
    
}
