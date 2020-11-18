package october;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3486/
 */
public class RotateList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null)
            return head;
        int size = 0;

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null) {
            size++;
            fastPointer = fastPointer.next;
        }

        fastPointer = head;

        k %= size;

        while (k-- > 0)
            fastPointer = fastPointer.next;

        while (fastPointer.next!=null)
        {
            fastPointer=fastPointer.next;
            slowPointer =slowPointer.next;
        }

        fastPointer.next=head;
        ListNode result=slowPointer.next;
        slowPointer.next=null;

        return result;
    }
}
