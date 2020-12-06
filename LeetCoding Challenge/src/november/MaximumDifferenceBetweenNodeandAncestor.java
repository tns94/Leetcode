package november;

import utils.TreeNode;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3525/
 */
public class MaximumDifferenceBetweenNodeandAncestor {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root,root.val,root.val);
    }
    int dfs(TreeNode node,int minAncestor, int maxAncestor)
    {
        if(node==null)
            return maxAncestor-minAncestor;

        int min=Math.min(minAncestor,node.val);
        int max=Math.max(maxAncestor,node.val);

        int left=dfs(node.left, min,max);
        int right=dfs(node.right,min,max);

        return Math.max(left,right);
    }
}
