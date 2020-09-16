package august;

import java.util.*;
/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3415/
 */
public class Vertical_Order_Traversal_of_a_Binary_Tree {

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

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, List<Integer>> map = new TreeMap<>();
        bfs(root, map);
        List<List<Integer>> answer = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            answer.add(entry.getValue());
        }
        return answer;
    }


    void bfs(TreeNode node,Map<Integer, List<Integer>> map)
    {
       Queue<TreeNode> queue=new LinkedList<>();
       Queue<Integer> indexQueue=new LinkedList<>();
       queue.offer(node);
       indexQueue.offer(0);
       while (!queue.isEmpty()){
           TreeNode tempNode=queue.poll();
           int tempIndex=indexQueue.poll();
           if(map.containsKey(tempIndex))
               map.get(tempIndex).add(tempNode.val);
           else
           {
               List<Integer> list=new ArrayList<>();
               list.add(tempNode.val);
               map.put(tempIndex,list);
           }
           if(tempNode.left!=null)
           {
               queue.offer(tempNode.left);
               indexQueue.offer(tempIndex-1);
           }
           if(tempNode.right!=null)
           {
               queue.offer(tempNode.right);
               indexQueue.offer(tempIndex+1);
           }

       }

    }
}
