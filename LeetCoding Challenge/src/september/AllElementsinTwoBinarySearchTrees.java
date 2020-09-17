package september;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3449/
 */

public class AllElementsinTwoBinarySearchTrees {
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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();

        inOrder(root1,list1);
        inOrder(root2,list2);

        return merge(list1,list2);
    }
    static List<Integer>  merge(List<Integer> list1,List<Integer> list2)
    {
        List<Integer> mergedList=new ArrayList<>();
        int i=0,j=0;
        while(j<list2.size() && i<list1.size() ) {

            if(list1.get(i)<list2.get(j))
                mergedList.add(list1.get(i++));
            else
                mergedList.add(list2.get(j++));
        }
        while (i<list1.size())
            mergedList.add(list1.get(i++));

        while (j<list2.size())
            mergedList.add(list2.get(j++));

        return mergedList;
    }
    static void inOrder(TreeNode node,List<Integer> list)
    {
        if(node==null)
            return;

        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }
}
