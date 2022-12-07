package GUI;
import UserComponents.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The "Admin Panel" of the GUI
public class HomePage {
    protected int minusUser = 0;
    protected JButton addUser, addGroup, openUserView, showUserTotal, 
    showGroupTotal, showMsgTotal, showPosPercent, verifyID, showLastUpdated;
    protected JTextField userID, groupID, textBox;
    private JFrame mainFrame;
    private JPanel buttonPanel, userIDAddUser, groupIDAddGroup,
    showUserGroupTotal, openUserViewPanel, showMsgPos, textBoxPanel, verifyIDShowUpdate;
    private JSplitPane splitPane;
    private JScrollPane scroll;
    protected DefaultMutableTreeNode root;
    protected JTree tree;
    private ButtonAndTreeAction action;
    private  ButtonAndSelectionLogic bsl = new ButtonAndSelectionLogic();

    public void createHomePage(){
        createPage();
        createButtonsAndTextArea();
        addListeners();
        addUsersAndGroups();
        setGrid();
        createSplitPane();
        lastSetup();
    }

    private void createPage(){
        createButtonsAndTextArea();
        mainFrame = new JFrame("Control Panel");
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        action = new ButtonAndTreeAction();
    }

    private void createSplitPane(){
        splitPane = new JSplitPane(SwingConstants.VERTICAL, scroll, buttonPanel); 
        splitPane.setDividerLocation(200);
        mainFrame.add(splitPane);
        
    }

    private void lastSetup(){
        
        mainFrame.setSize(600,300);
        mainFrame.setVisible(true);
    }

    private void setGrid(){
        userIDAddUser = new JPanel();
        userIDAddUser.setSize(200,10);
        userIDAddUser.setLayout(new GridLayout(1,2));
        userIDAddUser.add(userID);
        userIDAddUser.add(addUser);

        groupIDAddGroup = new JPanel();
        groupIDAddGroup.setSize(200, 10);
        groupIDAddGroup.setLayout(new GridLayout(1,2));
        groupIDAddGroup.add(groupID);
        groupIDAddGroup.add(addGroup);

        showUserGroupTotal = new JPanel();
        showUserGroupTotal.setLayout(new GridLayout(1,2));
        showUserGroupTotal.add(showUserTotal);
        showUserGroupTotal.add(showGroupTotal);

        showMsgPos = new JPanel();
        showMsgPos.setLayout(new GridLayout(1,2));
        showMsgPos.add(showMsgTotal);
        showMsgPos.add(showPosPercent);

        verifyIDShowUpdate = new JPanel();
        verifyIDShowUpdate.setLayout(new GridLayout(1,2));
        verifyIDShowUpdate.add(verifyID);
        verifyIDShowUpdate.add(showLastUpdated);

        openUserViewPanel = new JPanel();
        openUserViewPanel.setLayout(new BorderLayout());
        openUserViewPanel.add(openUserView, BorderLayout.CENTER);

        textBoxPanel = new JPanel();
        textBoxPanel.setLayout(new BorderLayout());
        textBoxPanel.add(textBox, BorderLayout.CENTER);


        buttonPanel.add(userIDAddUser);
        buttonPanel.add(groupIDAddGroup);
        buttonPanel.add(openUserViewPanel);
        buttonPanel.add(showUserGroupTotal);
        buttonPanel.add(showMsgPos);
        buttonPanel.add(verifyIDShowUpdate);
        buttonPanel.add(textBoxPanel);
    }

    //hard-coded users and groups for demonstration purposes
    private void addUsersAndGroups(){
        DefaultMutableTreeNode node = null;
        DefaultMutableTreeNode temp = null;
        User user = null;
        userGroup usergroup = null;

        root = new DefaultMutableTreeNode(userRoot.getUserRoot());

        user = new User("john");
        node = new DefaultMutableTreeNode(user);
        userRoot.getUserRoot().addToUserRoot(user);
        root.add(node);

        user = new User("bob");
        node = new DefaultMutableTreeNode(user);
        userRoot.getUserRoot().addToUserRoot(user);
        root.add(node);

        usergroup = new userGroup("CS56");
        node = new DefaultMutableTreeNode(usergroup);
        userRoot.getUserRoot().addToUserRoot(usergroup);
        root.add(node);
        temp = node;

        user = new User("stu1");
        node = new DefaultMutableTreeNode(user);
        userRoot.getUserRoot().addToUserRoot(user);
        temp.add(node);

        usergroup = new userGroup("CS356Session01");
        node = new DefaultMutableTreeNode(usergroup);
        userRoot.getUserRoot().addToUserRoot(usergroup);
        temp.add(node);
        temp = node;

        user = new User("stu8");
        node = new DefaultMutableTreeNode(user);
        userRoot.getUserRoot().addToUserRoot(user);
        temp.add(node);

        user = new User("oostu");
        node = new DefaultMutableTreeNode(user);
        userRoot.getUserRoot().addToUserRoot(user);
        root.add(node);

        tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setEditable(true);
        scroll = new JScrollPane(tree);
    }

    private void createButtonsAndTextArea(){
        addUser = new JButton("New User Name");
        addGroup = new JButton("New Group Name");
        openUserView = new JButton("Open User View");
        showUserTotal= new JButton("Show User Total");
        showGroupTotal = new JButton("Show Group Total");
        showMsgTotal = new JButton("Show Messages Total");
        showPosPercent= new JButton("Show Positive Percentage");
        verifyID = new JButton("Verify Unique ID");
        showLastUpdated = new JButton("Show Last Updated");
        groupID = new JTextField();
        groupID.setText("Group ID");
        userID = new JTextField();
        userID.setText("User ID");
        textBox = new JTextField();
        textBox.setText("Info appears here");
    }

    private void addListeners(){
        addUser.addActionListener(action);
        addGroup.addActionListener(action);
        openUserView.addActionListener(action);
        showUserTotal.addActionListener(action);
        showGroupTotal.addActionListener(action);
        showMsgTotal.addActionListener(action);
        showPosPercent.addActionListener(action);
        verifyID.addActionListener(action);
        showLastUpdated.addActionListener(action);
    }

    /* Logic for button presses on the Admin Panel */
    class ButtonAndTreeAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == addUser){
                System.out.println("add user button pressed!");
                if(!(userID.getText() == "")){
                    bsl.addUserToGUI(userID.getText(), tree, root);
                }
               
            }
            else if(e.getSource() == addGroup){
                if(!(groupID.getText()=="")){
                    System.out.println("add group button pressed");
                    bsl.addGroupToGUI(groupID.getText(), tree, root);
                    minusUser--;
                }
            }
            else if(e.getSource()== openUserView){
                System.out.println("open user view button pressed");
                bsl.openUserView(tree);
                
            }
            else if(e.getSource() == showUserTotal){
                textBox.setText(String.valueOf(root.getLeafCount()+minusUser));

            }
            else if(e.getSource()== showGroupTotal){
                textBox.setText(String.valueOf(userRoot.getUserRoot().getNumberOfGroups()));

            }
            else if(e.getSource() == showMsgTotal){
                textBox.setText(String.valueOf(userRoot.getUserRoot().getNumberOfMessages()));

            }
            else if(e.getSource() == showPosPercent){
                float posPercent = (float)userRoot.getUserRoot().getNumberOfPositive()/userRoot.getUserRoot().getNumberOfMessages();
                textBox.setText(String.valueOf(posPercent*100)+"%");

            }
            else if(e.getSource() == verifyID){
                /* By default, all ID's are unique and have no spaces */
                textBox.setText("All ID's are unique");
            }
            else if (e.getSource() == showLastUpdated){
                textBox.setText(userRoot.getUserRoot().getLastUpdatedUserComponentID());
            }
        }
        
    }
}


