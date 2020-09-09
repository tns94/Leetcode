package august;

import java.util.*;
/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3417/
 */
public class PathSumIII {

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

    static class llNode{
        int val;
        llNode parent;
        llNode(int val)
        {
            this.val=val;
        }
    }
    public int pathSum(TreeNode root, int sum) {

        Map<Integer,Integer> map=new HashMap<>();
        List<llNode> list=new ArrayList<>();
        dfs(root,null,list);
        int answer=0;
        for (llNode node:list)
        {
            llNode currentNode=node;
            int currentSum=currentNode.val;
            if(currentSum==sum)
                answer++;
            while ((currentNode=currentNode.parent)!=null)
            {
                currentSum+=currentNode.val;
                if(currentSum==sum)
                    answer++;
            }
        }
        return answer;
    }
    void dfs(TreeNode node, llNode parent, List<llNode> list)
    {
        if(node==null)
            return;
        llNode llnode=new llNode(node.val);
        llnode.parent=parent;
        list.add(llnode);

        dfs(node.left,llnode,list);
        dfs(node.right,llnode,list);
    }

  /*
    This solution is using formula left = node*2 , right= node*2+1
    But it will cause the index to get out of Integer or Long Range

    public int pathSum(TreeNode root, int sum) {

        Map<Integer,Integer> map=new HashMap<>();
        dfs(root,map,1);
        int answer=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {

            long index=entry.getKey();
            int currentSum=entry.getValue();
            if(currentSum==sum)
                answer++;
            while((index=index/2)>=1)
            {
                currentSum+=map.get(index);
                if(currentSum==sum)
                    answer++;
            }
        }
        return answer;
    }
    void dfs(TreeNode node,Map<Integer,Integer> map,int index)
    {
        if(node==null)
            return;
        map.put(index,node.val);
        dfs(node.left,map,index*2);
        dfs(node.right,map,(index*2)+1);
    }
*/
    public static void main(String[] args) {
        TreeNode tree=new TreeNode(0);
        TreeNode t1=new TreeNode(0);
        TreeNode t2=new TreeNode(0);
        TreeNode t3=new TreeNode(0);

        t2.left=t3;
        t1.left=t2;
        tree.left=t1;

        System.out.println(new PathSumIII().pathSum(tree,0));


    }
}
