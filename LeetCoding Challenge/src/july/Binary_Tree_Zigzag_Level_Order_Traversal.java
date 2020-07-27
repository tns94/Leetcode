package july;

import java.util.*;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3398/
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
            return list;
        dfs(root,0,list);
        return list;
    }

    void dfs(TreeNode node, int level, List<List<Integer>> list)
    {
        if(node==null)
            return;

        if(list.size()==level)
            list.add(new ArrayList<>());

        if(level%2==0) {
           list.get(level).add(node.val);
        }else{
            list.get(level).add(0,node.val);
        }
        dfs(node.left,level+1,list);
        dfs(node.right,level+1,list);
    }
}
