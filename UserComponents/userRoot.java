package UserComponents;
import java.util.*;
public class userRoot {
    private static userRoot uRoot = null;
    private int numberOfUsers = 0;
    private int numberOfGroups = 0;
    private int numberOfMessages = 0;
    private static HashSet<Integer> uniqueUsersAndGroups = new HashSet<Integer>();
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

    public List<userComponent> getUserRootList(){
        return userRootList;
    }

    public void addToUserRoot(userComponent ug){
        if(!uniqueUsersAndGroups.contains(ug.getID())){
            uRoot.add(ug);
            checkNumberOfUsersAndGroups(ug);
        }
       // checkForDuplicates(ug);
        
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
            return;
        }
        numberOfGroups++;
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
