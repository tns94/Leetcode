package february21;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3630/
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list =  new ArrayList<>();
        if (root==null)
            return list;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size=queue.size();
            TreeNode last=null;
            while (size-->0)
            {
                last=queue.poll();
                if(last.left!=null) queue.offer(last.left);
                if(last.right!=null) queue.offer(last.right);
            }
            list.add(last.val);
        }
        return list;
    }
}
