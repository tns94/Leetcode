package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3453/
 */
public class SumofRootToLeafBinaryNumbers {
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

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode node,int mask)
    {
        if(node==null)
            return 0;

        int tempMask=(mask<<1) | node.val;

        if(node.left==null && node.right==null)
            return tempMask;

        return dfs(node.left,tempMask) + dfs(node.right, tempMask);
    }
}
