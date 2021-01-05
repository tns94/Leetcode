package december;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3552/
 */
public class LinkedListRandomNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    List<Integer> list;
    public LinkedListRandomNode(ListNode head) {
        ListNode cur=head;
        list=new ArrayList<>();
        while(cur!=null)
        {
            list.add(cur.val);
            cur=cur.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int pick = (int)(Math.random() * this.list.size());
        return this.list.get(pick);
    }
}
