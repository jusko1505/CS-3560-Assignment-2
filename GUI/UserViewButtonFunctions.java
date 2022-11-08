package GUI;
import UserComponents.*;
public class UserViewButtonFunctions{
    private userObserverNotifier visitor = new userObserverNotifier();

    public void followUserButtonAction(User u, String UUID){
        u.follow(UUID);
        for(userComponent uc : userRoot.getUserRoot().getUserRootList()){
            if(uc.getID().equals(u.getID())){
                userRoot.getUserRoot().getUserRootList().remove(uc);
                userRoot.getUserRoot().getUserRootList().add(u);
            }
        }

    }
    public void postTweetButtonAction(User u, String Tweet){
        u.Tweet(Tweet, visitor);
        u.accept(visitor);
        for(userComponent uc : userRoot.getUserRoot().getUserRootList()){
            if(uc.getID().equals(u.getID())){
                userRoot.getUserRoot().getUserRootList().remove(uc);
                userRoot.getUserRoot().getUserRootList().add(u);
            }
        }

    }
}