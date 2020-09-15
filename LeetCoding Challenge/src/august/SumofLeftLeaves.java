package august;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3435/
 */
public class SumofLeftLeaves {

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


    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    int dfs(TreeNode root, boolean left) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            if (left)
                return root.val;
            else return 0;

        int sum = 0;
        sum += dfs(root.left, true);
        sum += dfs(root.right, false);
        return sum;
    }
}
