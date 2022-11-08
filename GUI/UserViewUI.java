package GUI;
import UserComponents.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class UserViewUI {
    private JFrame jframe;
    private JPanel mainPanel, userIDFollowUser, currentFolPanel, tweetPostpanel, newsFeedPanel, UUIDPanel;
    private JTextArea userID, tweetMessage;
    private JButton followUser, postTweet;
    private JList currentFollowing, newsFeed;
    private JTextField currFolText, newsFeedText, myUUIDtext, myUUID;
    private userViewAction action;
    private UserViewButtonFunctions ubf = new UserViewButtonFunctions();
    private User u;
    private JScrollPane followScroll, newsfeedScroll;
    /*
    private String[] following = {"jacob", "john", "jack"};
    private String[] news = {"disaster", "homework due", "traffic"};
     */

    private void initializeObjects(DefaultMutableTreeNode node){
        action = new userViewAction();
        u = (User)node.getUserObject();
        System.out.println(u.getID());
        for(String news: u.getNewsFeed()){
            System.out.println(news);
        }
        System.out.println(u.getFollowers());
        followScroll = new JScrollPane();
        newsfeedScroll = new JScrollPane();
        userID = new JTextArea("User ID");
        tweetMessage = new JTextArea("Tweet Message");
        followUser = new JButton("Follow User");
        followUser.addActionListener(action);
        postTweet = new JButton("Post Tweet");
        postTweet.addActionListener(action);
        currentFollowing = new JList(toArray(u.getFollowing()));
        newsFeed = new JList(toArray(u.getNewsFeed()));
        currFolText = new JTextField("Currently Following:");
        newsFeedText = new JTextField("News Feed:");
        myUUID = new JTextField((u.getID()));
        myUUIDtext = new JTextField("My UUID:");
    }

    private void buildGUI(){
        jframe = new JFrame("User View");
        //jframe.setDefaultCloseOperation();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        UUIDPanel = new JPanel();
        UUIDPanel.setLayout(new GridLayout(2,1));
        myUUIDtext.setEditable(false);
        myUUID.setEditable(false);
        UUIDPanel.add(myUUIDtext);
        UUIDPanel.add(myUUID);

        userIDFollowUser = new JPanel();
        userIDFollowUser.setLayout(new GridLayout(1,2));
        userIDFollowUser.add(userID);
        userIDFollowUser.add(followUser);

        currentFolPanel = new JPanel();
        currentFolPanel.setLayout(new GridLayout(2, 1));
        currFolText.setEditable(false);
        currentFolPanel.add(currFolText);
        followScroll.setViewportView(currentFollowing);
        currentFolPanel.add(followScroll);
        

        tweetPostpanel = new JPanel();
        tweetPostpanel.setLayout(new GridLayout(1,2));
        tweetPostpanel.add(tweetMessage);
        tweetPostpanel.add(postTweet);

        newsFeedPanel =  new JPanel();
        newsFeedPanel.setLayout(new GridLayout(2, 1));
        newsFeedText.setEditable(false);
        newsfeedScroll.setViewportView(newsFeed);
        newsFeedPanel.add(newsFeedText);
        newsFeedPanel.add(newsfeedScroll);
        
        mainPanel.add(UUIDPanel);
        mainPanel.add(userIDFollowUser);
        mainPanel.add(currentFolPanel);
        mainPanel.add(tweetPostpanel);
        mainPanel.add(newsFeedPanel);

        jframe.add(mainPanel);
        jframe.pack();
        jframe.setVisible(true);
    }
    private String[] toArray(List<String> list){
        String[] st = new String[list.size()];
        for(int i  = 0; i < list.size(); i++){
            st[i] = list.get(i);
        }
        System.out.println("Array length is: " +  st.length);
        return st;
    }

    public void initAndDisplayGUI(DefaultMutableTreeNode node){
        initializeObjects(node);
        buildGUI();
    }

    class userViewAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == followUser){
                ubf.followUserButtonAction(u, userID.getText());
            }
            if(e.getSource() == postTweet){
                ubf.postTweetButtonAction(u, tweetMessage.getText());

            }
            
        }
        
    }
/*
    public static void main(String[] args) {
        UserViewUI uvu = new UserViewUI();
        uvu.initAndDisplayGUI(node);

    }
     */
}
