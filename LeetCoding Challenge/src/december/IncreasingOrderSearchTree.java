package december;

import utils.TreeNode;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3553/
 */
public class IncreasingOrderSearchTree {
    TreeNode treeNode=new TreeNode();
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ret=treeNode;
        inOrder(root);
        return ret.right;
    }
    void inOrder(TreeNode node)
    {
        if(node==null)
            return;
        inOrder(node.left);
        treeNode.right=new TreeNode(node.val);
        treeNode=treeNode.right;
        inOrder(node.right);
    }
}
