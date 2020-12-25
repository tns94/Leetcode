package december;

import utils.TreeNode;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3577/
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int height=dfsHeight(root,0);
        System.out.println(height);
        return height >=0 ;
    }
    int dfsHeight(TreeNode node,int level)
    {
        if(node==null)
            return level;
        int heightLeft=dfsHeight(node.left,level+1);
        int heightRight=dfsHeight(node.right,level+1);
        if(heightLeft==-1 || heightRight==-1)
            return -1;
        if(Math.abs(heightLeft-heightRight)>1)
            return -1;
        return Math.max(heightLeft,heightRight);
    }
}
