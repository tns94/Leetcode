package december;

import utils.TreeNode;
/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3568/
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }
    Integer prev;
    boolean dfs(TreeNode node)
    {

        if(node==null)
            return true;

        if(!dfs(node.left)) return false;
        if(prev!=null && node.val<=prev)
            return false;
        prev=node.val;
        if(!dfs(node.right))return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateBinarySearchTree().isValidBST(new TreeNode(1,new TreeNode(1),null)));
    }
}
