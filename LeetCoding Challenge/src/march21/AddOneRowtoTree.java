package march21;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3666/
 */
public class AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1 || root== null)
        {
            TreeNode node=new TreeNode(v);
            node.left=root;
            return node;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        int level=1;
        while (!queue.isEmpty())
        {
            int size=queue.size();
            if(level != d-1) {
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            else{
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    TreeNode temp1=new TreeNode(v);
                    TreeNode temp2=new TreeNode(v);
                    temp1.left=node.left;
                    temp2.right=node.right;
                    node.left=temp1;
                    node.right=temp2;
                    queue.offer(temp1);
                    queue.offer(temp2);
                }
            }
            level++;
        }
        return root;
    }
}
