package july;
/*
https://leetcode.com/submissions/detail/364789249/?from=/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3386/
 */
public class Flatten_a_Multilevel_Doubly_Linked_List {

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }



    public Node flatten(Node head) {
        flattenHelper(head);
        return head;
    }

    Node flattenHelper(Node node) {
        if (node.next == null && node.child == null)
            return node;
        Node current = node;
        while (current.next != null) {
            if (current.child != null) {
                Node nextNode = current.next;
                current.next = current.child;
                current.child.prev = current;

                current.child = null;
                Node lastEnd = flattenHelper(current.next);

                lastEnd.next = nextNode;
                nextNode.prev = lastEnd;
                current = nextNode;
            } else {
                current = current.next;
            }
        }
        if (current.child != null) {
            current.next = current.child;
            current.child.prev = current;
            current.child = null;
            current = flattenHelper(current.next);
        }
        return current;

    }
}
