package february21;
/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3635/
 */
public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        Node cur=head;
        while (cur != null){
            Node temp=new Node(cur.val);
            Node nextNode=cur.next;
            cur.next=temp;
            temp.next=nextNode;
            cur=nextNode;
        }
        cur=head;
        while (cur != null)
        {
            cur.next.random=cur.random == null ? null : cur.random.next;
            cur=cur.next.next;
        }
        cur= head;
        Node newNode=new Node(0);
        Node newCur=newNode;
        while (cur != null)
        {
            Node nextNode=cur.next.next;
            newCur.next=cur.next;
            newCur=newCur.next;
            cur.next=nextNode;
            cur = nextNode;
        }
        return newNode.next;
    }
}
