package UserComponents;
import java.util.*;

/* The userRoot is a singleton that contains ALL users and usergroups */
public class userRoot {
    private static HashSet<String> uniqueUsersAndGroups = new HashSet<String>();
    private List<userComponent> userRootList = new ArrayList<userComponent>();
    private static userRoot uRoot = null;
    private int numberOfUsers = 0;
    private int numberOfGroups = 0;
    private int numberOfMessages = 0;
    private int numberOfPositive = 0;
    private String name = "root";

    // Private constructor
    private userRoot(){
    }

    // Public static getInstance type of method
    public static userRoot getUserRoot(){
        if(uRoot == null){
            uRoot = new userRoot();
        }
        return uRoot;
    }

    public String getLastUpdatedUserComponentID(){
        long lastUpdated = 0;
        String id = "";
        for(userComponent uc: userRootList){
            if(uc.getLastUpdated()>lastUpdated){
                id = uc.getID();
            }
        }
        return id;
    }

    // A user or group has had a change, remove and add updated
    public void updateUserRoot(userComponent updatedUser){
        if(uniqueUsersAndGroups.contains(updatedUser.getID())){
            for(userComponent uc: userRootList){
                if(updatedUser.getID() == uc.getID()){
                    userRootList.remove(uc);
                    userRootList.add(updatedUser);
                }
            }
        }
    }

    public void addToUserRoot(userGroup usergroup){
        if(!uniqueUsersAndGroups.contains(usergroup.getID())){
            uRoot.add(usergroup);
            numberOfGroups++;
            System.out.print("added a group ");
            System.out.println(usergroup.getName());
        }
    }

    public void addToUserRoot(User user){
        if(!uniqueUsersAndGroups.contains(user.getID())){
            uRoot.add(user);
            numberOfUsers++;
            System.out.print("added a user ");
            System.out.println(user.getName());
        }
    }
    
    public int getNumberOfPositive() {
        return numberOfPositive;
    }

    public void setNumberOfPositive(int numberOfPositive) {
        this.numberOfPositive = numberOfPositive;
    }

    // Required for GUI to display properly
    public String toString(){
        return "root";
    }

    public String getName(){
        return name;
    }

    public int getNumberOfMessages(){
        return numberOfMessages;
    }
    public void setNumberOfMessages(int number){
        this.numberOfMessages = number;
    }

    public HashSet<String> returnUniqueID(){
        return uniqueUsersAndGroups;
    }

    // Contains all users and userGroups in the root
    public List<userComponent> getUserRootList(){
        return userRootList;
    }

    public int getNumberOfUsers(){
        return numberOfUsers;
    }

    public int getNumberOfGroups(){
        return numberOfGroups;
    }

    private void add(userComponent uc){
        this.userRootList.add(uc);
    } 
}
