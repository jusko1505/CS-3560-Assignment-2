package UserComponents;
import java.util.*;
public class userGroup extends userComponent implements userGroupInterface{
    private String groupID;
    private String groupName;
    private ArrayList<userComponent> userComponents = new ArrayList<userComponent>();
    //private static HashSet<Integer> uniqueUsers = new HashSet<Integer>();

    public userGroup(String groupName){
        this.groupID = UUID.randomUUID().toString();
        this.groupName = groupName;
    }

    public String getName() {
        return groupName;
    }
    public List<String> getTweets(){
        return new ArrayList<String>();
    }

    
    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return groupID;
    }

    public String toString(){
        return this.groupName;
    }

    @Override
    public List<userComponent> getUserComponents(userComponent uc) {
        // TODO Auto-generated method stub
        return this.userComponents;
    }

    @Override
    public List<userComponent> getListOfUserGroups() {
        return userComponents;
    }

    public void addUserGroup(userComponent uc){
        this.userComponents.add(uc);
    }

    public void removeUserGroup(userComponent uc){
        this.userComponents.remove(uc);
    }
}
