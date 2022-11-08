package UserComponents;
//dont need?
public class userGroupAndRoot {
    private userRoot ur = userRoot.getUserRoot();
    private int numberOfUsers = 0;
    private int numberOfGroups = 0;

    public void addUser(String name){
        User u = new User(name);
        numberOfUsers++;
    }

    public void addGroup(String name){
        userGroup ug = new userGroup(name);
        numberOfGroups++;
    }

    public void addToGroup(userComponent uc, userGroup group){
        group.addUserGroup(uc);


    }
}
