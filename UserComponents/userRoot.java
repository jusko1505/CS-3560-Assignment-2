package UserComponents;
import java.util.*;
public class userRoot {
    private static userRoot uRoot = null;
    private int numberOfUsers = 0;
    private int numberOfGroups = 0;
    private int numberOfMessages = 0;
    private static HashSet<String> uniqueUsersAndGroups = new HashSet<String>();
    private List<userComponent> userRootList = new ArrayList<userComponent>();
    private String name = "root";
    
    private userRoot(){
    }

    public static userRoot getUserRoot(){
        if(uRoot == null){
            uRoot = new userRoot();
        }
        return uRoot;
    }

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

    public List<userComponent> getUserRootList(){
        return userRootList;
    }

    public void updateUserRoot(userComponent updatedUser){
        if(uniqueUsersAndGroups.contains(updatedUser.getID())){
            for(userComponent uc: userRootList){
                if(updatedUser.getID()==uc.getID()){
                    userRootList.remove(uc);
                    userRootList.add(updatedUser);
                }
            }
        }
    }

    /*
    public void addToUserRoot(userComponent ug){
        if(!uniqueUsersAndGroups.contains(ug.getID())){
            uRoot.add(ug);
            checkNumberOfUsersAndGroups(ug);
        }
       // checkForDuplicates(ug);
    }
     */
    public void addToUserRoot(userGroup usergroup){
        if(!uniqueUsersAndGroups.contains(usergroup.getID())){
            uRoot.add(usergroup);
            numberOfGroups++;
            System.out.print("added a group ");
            System.out.println(usergroup.getGroupName());
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

    public int getNumberOfUsers(){
        return numberOfUsers;
    }

    public int getNumberOfGroups(){
        return numberOfGroups;
    }

    private void checkNumberOfUsersAndGroups(userComponent ug){
        if(ug.getUserComponents(ug).size()==0){
            numberOfUsers++;
            System.out.println("added a user");
            return;
        }
        numberOfGroups++;
        System.out.println("added a group");
        for(userComponent com: ug.getUserComponents(ug)){
            checkNumberOfUsersAndGroups(com);
        }
        
    }

    private void add(userComponent uc){
        this.userRootList.add(uc);
    } 

    /* 
    private void checkForDuplicates(userComponent ug){
        List<userComponent> myList = ug.getUserComponents(ug);
        if(myList.size()==1){
            userComponent temp = myList.get(0);
            int id = temp.getID();
            if(uniqueUsers.contains(id)){
                uniqueUsers.remove(id);
            }
            
        }
        checkForDuplicates(ug);
    }
    */
}
