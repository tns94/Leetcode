package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3524/
 */
public class BinaryTreeTilt {
    int tilt=0;
    public int findTilt(TreeNode root) {
        getSum(root);
        return tilt;
    }
    int getSum(TreeNode node)
    {
        if(node==null)
            return 0;
        int leftSum=getSum(node.left);
        int rightSum=getSum(node.right);
        tilt+=Math.abs(leftSum-rightSum);
        return leftSum+rightSum+node.val;
    }


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
}
