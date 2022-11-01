import java.util.*;
public class userGroup implements userGroupInterface{
    private int groupID;

    public userGroup(){
        this.groupID = Integer.parseInt(UUID.randomUUID().toString());
    }
    @Override
    public int getGroupID() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<User> getListOfUsers() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
