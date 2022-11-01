import java.util.*;
public class userRoot {
    private static userRoot uRoot = null;
    private HashSet<userGroup> groupList;
    
    private userRoot(){
    }

    public static userRoot getUserRoot(){
        if(uRoot == null){
            uRoot = new userRoot();
        }
        return uRoot;
    }

    public void addToUserRoot(userGroup ug){
        this.groupList.add(ug);
    }
}
