package GUI;
import UserComponents.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/* This class provides the logic for the admin panel's buttons */
public class ButtonAndSelectionLogic {

    /* 
     * Create a new User object, wrapped in a DefaultMutableTreeNode.
     * New TreeNode is added as a child of the selected node.
     */
    public void addUserToGUI(String userName, JTree tree, DefaultMutableTreeNode root){
        User user = new User(userName);
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(user);
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
        UserComponents.userRoot.getUserRoot().addToUserRoot(user);
        parentNode.add(node);
        DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
        model.reload(root);
    }

    /* 
     * Create a new userGroup object, wrapped in a DefaultMutableTreeNode.
     * New TreeNode is added as a child of the selected node.
     */
    public void addGroupToGUI(String groupName, JTree tree, DefaultMutableTreeNode root){
        userGroup group = new userGroup(groupName);
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(group);
        DefaultMutableTreeNode temp = new DefaultMutableTreeNode("null");
        node.add(temp);
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
        UserComponents.userRoot.getUserRoot().addToUserRoot(group);
        parentNode.add(node);
        DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
        model.reload(root);
    }

    public int getNumberOfGroups(DefaultMutableTreeNode root, int minusUser){
       return userRoot.getUserRoot().getNumberOfUsers()-root.getLeafCount();
    }

    /*
     * Starts the UserViewUI
     */
    public void openUserView(JTree tree){
        DefaultMutableTreeNode selectedUser = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
        UserViewUI uv = new UserViewUI();
        uv.initAndDisplayGUI(selectedUser);
    }
}
