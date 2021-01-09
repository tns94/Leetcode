package december;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3556/
 */
public class PopulatingNextRightPointersinEachNodeII {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        levelOrderTraversal(root);
        return root;
    }
    void levelOrderTraversal(Node root)
    {
        if(root==null)
            return;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count=queue.size();
            Node prev=null;
            while (count-->0)
            {
                Node node=queue.poll();
                if(prev!=null)
                    prev.next=node;
                prev=node;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
    }
}
