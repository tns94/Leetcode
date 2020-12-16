package november;

import com.sun.jmx.snmp.SnmpNull;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3529/
 */
public class PopulatingNextRightPointersinEachNode {
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
