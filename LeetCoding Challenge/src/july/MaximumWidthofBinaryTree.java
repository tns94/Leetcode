package july;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3385/
 */

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthofBinaryTree {

    //For a level max index and min index
    Map<Integer,Integer> rightMax=new HashMap<>();
    Map<Integer,Integer> leftMin=new HashMap<>();
    int maxLength=0;
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
    public int widthOfBinaryTree(TreeNode root) {
        traverse(root,0,1);
        return maxLength;
    }
    public void traverse(TreeNode node,int level,int index)
    {
        if(node==null)
            return;
        if(node.left!=null)
            traverse(node.left,level+1,index*2);
        if(node.right!=null)
            traverse(node.right,level+1,index*2+1);

        if(rightMax.containsKey(level))
        {
            if(rightMax.get(level)<index)
                rightMax.put(level,index);
        }
        else
            rightMax.put(level,index);

        if(leftMin.containsKey(level))
        {
            if(leftMin.get(level)>index)
                leftMin.put(level,index);
        }
        else
            leftMin.put(level,index);
        int maxTemp=(rightMax.get(level)-leftMin.get(level))+1;
        if(maxTemp > maxLength)
            maxLength=maxTemp;
    }

}
