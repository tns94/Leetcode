package november;

import utils.TreeNode;


/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3541/
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] arr=dfs(root);
        return Math.max(arr[0],arr[1]);
    }
    int[] dfs(TreeNode root) {
        if(root==null)
            return new int[]{0,0};
        int[] leftSum = dfs(root.left);
        int[] rightSum = dfs(root.right);

        return new int[]{ root.val+ leftSum[1]+rightSum[1],Math.max(leftSum[0],leftSum[1])+Math.max(rightSum[0],rightSum[1])};
    }

}
