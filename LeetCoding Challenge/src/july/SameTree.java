package july;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3389/
 */
public class SameTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean leftResult=false,rightResult=false;

        if(p==null && q==null)
            return true;

        if(p == null  || q ==null || p.val != q.val)
            return false;

        leftResult=isSameTree(p.left,q.left);
        rightResult=isSameTree(p.right,q.right);

        return leftResult && rightResult;
    }
}
