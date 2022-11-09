package GUI;
import UserComponents.*;

/* This class provides the logic for the userView's buttons */
public class UserViewButtonFunctions{
    private userObserverNotifier visitor = new userObserverNotifier();

    // Follows the user with the inputed UUID
    public void followUserButtonAction(User u, String UUID){
        u.follow(UUID);
        for(userComponent uc : userRoot.getUserRoot().getUserRootList()){
            if(uc.getID().equals(u.getID())){
                userRoot.getUserRoot().getUserRootList().remove(uc);
                userRoot.getUserRoot().getUserRootList().add(u);
            }
        }

    }

    // Posts tweet
    public void postTweetButtonAction(User u, String Tweet){
        u.Tweet(new Tweet(Tweet), visitor);
        u.accept(visitor);
        for(userComponent uc : userRoot.getUserRoot().getUserRootList()){
            if(uc.getID().equals(u.getID())){
                userRoot.getUserRoot().getUserRootList().remove(uc);
                userRoot.getUserRoot().getUserRootList().add(u);
            }
        }

    }
}