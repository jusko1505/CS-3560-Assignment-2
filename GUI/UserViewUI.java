package GUI;
import java.awt.*;

import javax.swing.*;

public class UserViewUI {
    private JFrame jframe;
    private JPanel mainPanel, userIDFollowUser, currentFolPanel, tweetPostpanel, newsFeedPanel;
    private JTextArea userID, tweetMessage;
    private JButton followUser, postTweet;
    private JList currentFollowing, newsFeed;
    private JTextField currFolText, newsFeedText;
    private String[] following = {"jacob", "john", "jack"};
    private String[] news = {"disaster", "homework due", "traffic"};

    private void initializeObjects(){
        userID = new JTextArea("User ID");
        tweetMessage = new JTextArea("Tweet Message");
        followUser = new JButton("Follow User");
        postTweet = new JButton("Post Tweet");
        currentFollowing = new JList<String>(following);
        newsFeed = new JList<String>(news);
        currFolText = new JTextField("Currently Following:");
        newsFeedText = new JTextField("News Feed:");
    }

    private void buildGUI(){
        jframe = new JFrame("User View");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        userIDFollowUser = new JPanel();
        userIDFollowUser.setLayout(new GridLayout(1,2));
        userIDFollowUser.add(userID);
        userIDFollowUser.add(followUser);

        currentFolPanel = new JPanel();
        currentFolPanel.setLayout(new GridLayout(2, 1));
        currFolText.setEditable(false);
        currentFolPanel.add(currFolText);
        currentFolPanel.add(currentFollowing);
        

        tweetPostpanel = new JPanel();
        tweetPostpanel.setLayout(new GridLayout(1,2));
        tweetPostpanel.add(tweetMessage);
        tweetPostpanel.add(postTweet);

        newsFeedPanel =  new JPanel();
        newsFeedPanel.setLayout(new GridLayout(2, 1));
        newsFeedText.setEditable(false);
        newsFeedPanel.add(newsFeedText);
        newsFeedPanel.add(newsFeed);
        

        mainPanel.add(userIDFollowUser);
        mainPanel.add(currentFolPanel);
        mainPanel.add(tweetPostpanel);
        mainPanel.add(newsFeedPanel);

        jframe.add(mainPanel);
        jframe.pack();
        jframe.setVisible(true);
    }
    private void initAndDisplayGUI(){
        initializeObjects();
        buildGUI();
    }

    public static void main(String[] args) {
        UserViewUI uvu = new UserViewUI();
        uvu.initAndDisplayGUI();

    }
}
