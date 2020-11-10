package october;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3504/
 */
public class MinimumDepthofBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=1;
        while (!queue.isEmpty())
        {
            int size=queue.size();
            while (size-->0)
            {
                TreeNode node=queue.poll();
                if(node.left==null && node.right==null) return depth;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
