package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3509/
 */
public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        while (fast!=null && fast.next!= null && slow!=fast)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        if(slow==fast)
        {
            slow=head;
            while (slow != fast)
            {
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        else return null;
    }
}