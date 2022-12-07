package UserComponents;
import java.util.*;

// The data and functionality of a User
public class User extends userComponent implements userInterface, Visitable, Observable, Observer{
    private String ID;
    private String name;
    private long creationTime;
    private long lastUpdated;
    private List<String> followers;
    // Following holds UUID's
    private List<String> following;
    // FollowingName holds the corresponding names for those UUID's
    private List<String> followingName;
    private List<String> newsFeed;
    private List<Tweet> myTweets;
    // A user can Observer or be Observable
    private List<Observer> observers;

    // Constructor
    public User(String name) {
        this.ID = UUID.randomUUID().toString();
        this.name = name;
        this.followers = new ArrayList<String>();
        this.following = new ArrayList<String>();
        this.newsFeed = new ArrayList<String>();
        this.myTweets= new ArrayList<Tweet>();
        this.followingName = new ArrayList<String>();
        this.creationTime = System.currentTimeMillis();
        this.lastUpdated = creationTime;
    }

    /* Methods from userComponent */

    /*
     * This method is meant for userGroup to return all users
     * in that group. Since this is not a userGroup, it returns
     * an empty List.
     */
    @Override
    public List<userComponent> getUserComponents(userComponent uc) {
        ArrayList<userComponent> leaf = new ArrayList<userComponent>();
        return leaf;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public List<Tweet> getTweets(){
        return myTweets;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void addObserver(Observer ob) {
        if(observers==null){
            observers = new ArrayList<Observer>();
        }
        observers.add(ob);
    }

    @Override
    public long getCreationTime() {
        return this.creationTime;
    }

    @Override
    public long getLastUpdated() {
        return this.lastUpdated;
    }


    /* Methods from userInterface.java */ 

    // toString method required to properly display names in GUI
    public String toString(){
        return name;
    }

    public List<String> getFollowers() {
        return this.followers;
        
    }

    public List<String> getFollowing() {
        if(following.size() == 0){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add("You are not following anyone");
            return temp;
        }
        return this.following;
    }

    public List<String> getNewsFeed() {
        updateNewsFeed();
        if(newsFeed.size()==0){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add("No news yet");
            return temp;
        }
        return this.newsFeed;
    }

    public List<String> getFollowingName(){
        return this.followingName;
    }

    /*
     * Goes through each of the users you are following, 
     * and adds their tweets to your feed
     */
    public void updateNewsFeed(){
        newsFeed = new ArrayList<String>();
        for(String UUID: following){
            for (userComponent uc : userRoot.getUserRoot().getUserRootList()){
                if(UUID.equals(uc.getID())){
                    for(Tweet tweet: uc.getTweets()){
                        newsFeed.add(uc.getName()+": "+tweet.getTweet());
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

    public void setFollowers(List<String> list){
        this.followers = list;
    }

    /* Methods from Vistable.java */

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void Tweet(Tweet myTweet, Visitor v){
        if(myTweet.getPositive()==true){
            userRoot.getUserRoot().setNumberOfPositive(userRoot.getUserRoot().getNumberOfPositive()+1);
        }
        userRoot.getUserRoot().setNumberOfMessages(userRoot.getUserRoot().getNumberOfMessages()+1);
        myTweets.add(myTweet);
        accept(v);
        lastUpdated = System.currentTimeMillis();
        System.out.println("successfully tweeted out");
    }

    /* Method from Observable */

    public List<Observer> getObservers(){
        if(observers==null){
            return null;
        }
        return this.observers;
    }

    /* Method from Observer */
   
    public void update(){
        System.out.println("You have a notification!");
    }
    
}
