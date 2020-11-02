package october;

import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3516/
 */
public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {
        ListNode cur=head;
        int result=0;
        while (cur != null)
        {
            result <<= 1;
            result |= cur.val;
            cur=cur.next;
        }
       return result;
    }


     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
