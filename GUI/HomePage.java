package GUI;
import UserComponents.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
    private JButton addUser, addGroup, openUserView, showUserTotal, 
    showGroupTotal, showMsgTotal, showPosPercent;
    private JTextArea userID, groupID, textBox;
    private JFrame mainFrame;
    private JPanel rootPanel, buttonPanel, userIDAddUser, groupIDAddGroup,
    showUserGroupTotal, openUserViewPanel, showMsgPos, textBoxPanel;
    private JSplitPane splitPane;
    private JList<String> rootList;
    private JScrollPane scroll;
    private DefaultMutableTreeNode root;
    private JTree tree;
    private ButtonAndTreeAction action;
    //private Container buttonContainer;
    private String[] groups = {"stu1", "stu2", "cs3560", "sports", "club"};

    private void createPage(){
        createButtonsAndTextArea();
        mainFrame = new JFrame("Control Panel");
        //mainFrame.setSize(1000, 600);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        action = new ButtonAndTreeAction();
    }

    /*
    private void createScrollPane(){
        rootList = new JList<String>(groups);
        rootScrollPane = new JScrollPane(rootList);
    }
    */
    private void createSplitPane(){
        splitPane = new JSplitPane(SwingConstants.VERTICAL, scroll, buttonPanel); 
        splitPane.setDividerLocation(200);
        mainFrame.add(splitPane);
        
    }

    private void lastSetup(){
        
        //mainFrame.pack();
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
        userRoot.getUserRoot().addToUserRoot(usergroup);
        temp.add(node);

        user = new User("oostu");
        node = new DefaultMutableTreeNode(user);
        userRoot.getUserRoot().addToUserRoot(user);
        root.add(node);

        tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(action);
        tree.setEditable(true);
        scroll = new JScrollPane(tree);
    }
    private void createButtonsAndTextArea(){
        addUser = new JButton("Add User");
        addGroup = new JButton("Add Group");
        openUserView = new JButton("Open User View");
        showUserTotal= new JButton("Show User Total");
        showGroupTotal = new JButton("Show Group Total");
        showMsgTotal = new JButton("Show Messages Total");
        showPosPercent= new JButton("Show Positive Percentage");
        groupID = new JTextArea();
        groupID.setText("Group ID");
        userID = new JTextArea();
        userID.setText("User ID");
        textBox = new JTextArea("Info appears here.");
    }

    private void addListeners(){
        addUser.addActionListener(action);
        addGroup.addActionListener(action);
        openUserView.addActionListener(action);
        showUserTotal.addActionListener(action);
        showGroupTotal.addActionListener(action);
        showMsgTotal.addActionListener(action);
        showPosPercent.addActionListener(action);
    }


    public void createHomePage(){
        createPage();
        createButtonsAndTextArea();
        addUsersAndGroups();
        setGrid();
        createSplitPane();
        lastSetup();
    }
    public static void main(String[] args) {
        HomePage hp = new HomePage();
        hp.createHomePage();
    }


    class ButtonAndTreeAction implements ActionListener, TreeSelectionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == addUser){
                if(addUser.getText()!=null){
                    User user = new User(addUser.getText());
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(user);
                    UserComponents.userRoot.getUserRoot().addToUserRoot(user);
                    root.add(node);
                    tree.updateUI();
                }
               
            }
            else if(e.getSource() == addGroup){
                if(addGroup.getText()!=null){
                    DefaultMutableTreeNode node = null;
                    node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                }
               
            }
            else if(e.getSource()== openUserView){
                
            }
            else if(e.getSource() == showUserTotal){
                textBox.setText(String.valueOf(UserComponents.userRoot.getUserRoot().getNumberOfUsers()));

            }
            else if(e.getSource()== showGroupTotal){

            }
            else if(e.getSource() == showMsgTotal){

            }
            else if(e.getSource() == showPosPercent){

            }
        }

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            
            
        }
        
    }
}


