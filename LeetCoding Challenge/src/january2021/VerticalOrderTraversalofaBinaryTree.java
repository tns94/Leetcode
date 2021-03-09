package january2021;

import utils.TreeNode;

import java.util.*;

/*
https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/583/week-5-january-29th-january-31st/3621/
 */
public class VerticalOrderTraversalofaBinaryTree {
    class Pair {
        int x,y,val;

        public Pair(int x, int y,int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer,List<Integer>> map=new TreeMap<>();
        PriorityQueue<Pair> queue=new PriorityQueue<>((o1, o2) ->
                o1.x != o2.x ? o1.x - o2.x :
                        o1.y != o2.y ?o1.y - o2.y :
                                o1.val - o2.val);
        dfs(root,0,0,queue);

        List<List<Integer>> list=new ArrayList<>();
        Integer prevXIndex = null;
        List<Integer> subArray = new ArrayList<>();
        while(!queue.isEmpty()){
            Pair head = queue.poll();
            if(prevXIndex!= null && head.x!=prevXIndex){
                list.add(subArray);
                subArray =new ArrayList<>();
            }
            subArray.add(head.val);
            prevXIndex = head.x;
        }
        if(subArray.size()>0){
            list.add(subArray);
        }

        return list;

    }
    void dfs(TreeNode root,int x,int y,PriorityQueue<Pair> queue)
    {
        if(root == null)
            return;

        queue.offer(new Pair(x, y, root.val ));
        dfs(root.left, x-1, y+1,queue);
        dfs(root.right, x+1, y+1,queue);
    }
}
