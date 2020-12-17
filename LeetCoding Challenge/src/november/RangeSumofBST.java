package november;

import utils.TreeNode;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3532/
 */
public class RangeSumofBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
            return 0;
        if(root.val > high)
            return rangeSumBST(root.left,low,high);
        else if(root.val < low)
            return rangeSumBST(root.right,low,high);
        else
        {
            return root.val
                    + rangeSumBST(root.left,low,high)
                    + rangeSumBST(root.right,low,high);
        }
    }
}
