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
        Map<Integer,List<Integer>> map=new TreeMap<>(Comparator.reverseOrder());
        List<Integer> firstLevel=new ArrayList<>();
        firstLevel.add(root.val);
        map.put(0,firstLevel);
        traverse(root,map,1);
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
            answer.add(entry.getValue());
        }
        return answer;
    }

    static void traverse(TreeNode node,Map<Integer,List<Integer>> map,int level)
    {
        if(node==null)
            return;

        if(node.left!=null)
        {
            if(!map.containsKey(level))
                map.put(level,new ArrayList<>());
            traverse(node.left,map,level+1);
            map.get(level).add(node.left.val);
        }
        if(node.right!=null)
        {
            if(!map.containsKey(level))
                map.put(level,new ArrayList<>());
            traverse(node.right,map,level+1);
            map.get(level).add(node.right.val);
        }
    }
}
