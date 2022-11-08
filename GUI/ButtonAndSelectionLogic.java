package GUI;
import UserComponents.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ButtonAndSelectionLogic {
    public void addUserToGUI(String userName, JTree tree, DefaultMutableTreeNode root){
        User user = new User(userName);
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(user);
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
        UserComponents.userRoot.getUserRoot().addToUserRoot(user);
        parentNode.add(node);
        DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
        model.reload(root);
    }

    public void addGroupToGUI(String groupName, JTree tree, DefaultMutableTreeNode root){
        userGroup group = new userGroup(groupName);
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(group);
        DefaultMutableTreeNode temp = new DefaultMutableTreeNode("null");
        node.add(temp);
        //node.remove(0);
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
        UserComponents.userRoot.getUserRoot().addToUserRoot(group);
        parentNode.add(node);
        DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
        model.reload(root);
    }

    public int getNumberOfGroups(DefaultMutableTreeNode root, int minusUser){
       return userRoot.getUserRoot().getNumberOfUsers()-root.getLeafCount();
    }

    public void openUserView(JTree tree){
        DefaultMutableTreeNode selectedUser = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
        UserViewUI uv = new UserViewUI();
        uv.initAndDisplayGUI(selectedUser);
    }
}
