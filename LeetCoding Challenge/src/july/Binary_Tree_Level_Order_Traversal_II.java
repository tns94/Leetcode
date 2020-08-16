package july;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal_II {

    static class TreeNode {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer=new ArrayList<>();
        if(root==null)
            return answer;
        traverse(root,answer,0);
        return answer;
    }

    static void traverse(TreeNode node,List<List<Integer>> list,int level)
    {
        if(node==null)
            return;

        if(level==list.size())
        {
            list.add(0,new ArrayList<>());
        }
        list.get(list.size()-level-1).add(node.val);
        traverse(node.left,list,level+1);
        traverse(node.right,list,level+1);
    }

}
