package december;

import utils.TreeNode;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3585/
 */
public class PseudoPalindromicPathsinaBinaryTree {

    int count = 0;
    //Using bitmask instead of boolean array
    public void preorder(TreeNode node, int path) {
        if (node != null) {
            // compute occurences of each digit
            // in the corresponding register
            path = path ^ (1 << node.val);
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path) ;
        }
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        preorder(root, 0);
        return count;
    }
    /* USing boolean array
    public int pseudoPalindromicPaths (TreeNode root) {
        boolean[] counter=new boolean[10];
        return dfs(root,counter);
    }
    int dfs(TreeNode root,boolean[] counter)
    {
        if(root==null) return 0;
        if(root.left==null && root.right==null)
        {
            counter[root.val]=!counter[root.val];
            boolean isp=isPalindromic(counter);
            counter[root.val]=!counter[root.val];
            return isp?1:0;
        }
        counter[root.val]=!counter[root.val];
        int ans=dfs(root.left,counter) + dfs(root.right,counter);
        counter[root.val]=!counter[root.val];
        return ans;
    }
    boolean isPalindromic(boolean[] counter)
    {
        int trueCount=0;
            for(boolean value:counter)
                if(value) trueCount++;
            return trueCount <= 1;
    }*/
}
