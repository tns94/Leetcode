package december;

import utils.TreeNode;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3551/
 */
public class MaximumDepthofBinaryTree {
    int max=0;
    public int maxDepth(TreeNode root) {
        dfs(root,1);
        return max;
    }
    void dfs(TreeNode root,int level){
        if(root==null)
        {
            max=Math.max(max,level);
            return;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}
