package UserComponents;
import java.util.*;
public interface userInterface {
    public String toString();
    public List<String> getFollowers();
    public List<String> getFollowing();
    public List<String> getNewsFeed();
    public List<String> getFollowingName();
    public void setFollowers(List<String> list);
    public void updateNewsFeed();
    public void follow(String UUID);

}
