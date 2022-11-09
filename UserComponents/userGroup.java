package UserComponents;
import java.util.*;

// A userGroup contains Users
public class userGroup extends userComponent implements userGroupInterface{
    private String groupID;
    private String groupName;
    // A userGroup can hold Users and recursively hold other userGroups
    private ArrayList<userComponent> userComponents = new ArrayList<userComponent>();
   

    //Constructor
    public userGroup(String groupName){
        this.groupID = UUID.randomUUID().toString();
        this.groupName = groupName;
    }
    
    /* Methods from userComponent */

    @Override
    public List<userComponent> getUserComponents(userComponent uc) {
        return this.userComponents;
    }

    @Override
    public String getID() {
        return groupID;
    }

    @Override
    public List<Tweet> getTweets(){
        return new ArrayList<Tweet>();
    }

    @Override
    public String getName() {
        return groupName;
    }
  
    /* Methods from userGroupInterface */

    public void addUserGroup(userComponent uc){
        this.userComponents.add(uc);
    }

    public void removeUserGroup(userComponent uc){
        this.userComponents.remove(uc);
    }
    
    public List<userComponent> getListOfUserGroups() {
        return userComponents;
    }

    // toString method required to properly display names in GUI
    public String toString(){
        return this.groupName;
    }
}
