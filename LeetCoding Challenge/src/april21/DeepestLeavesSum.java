package april21;

import utils.TreeNode;

/*
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3704/
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = maxDepth(root,0);
        return sum(root,maxDepth,0);
    }
    int maxDepth(TreeNode node,int level)
    {
        if(node == null)
            return level-1;

        return Math.max(maxDepth(node.left,level+1)
                ,maxDepth(node.right,level+1));
    }
    int sum(TreeNode node, int maxDepth, int level)
    {
        if(node == null)
            return 0;

        if(level == maxDepth)
            return node.val;

        return sum(node.left,maxDepth,level+1)+sum(node.right,maxDepth,level+1);
    }
}
