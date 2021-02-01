package january21;

import utils.ListNode;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3593/
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode();
        ListNode prev=new ListNode();
        dummy.next=head;
        prev=dummy;
        boolean flag=false;
        ListNode cur=head;
        while (cur != null && cur.next !=null)
        {
            if(cur.val == cur.next.val)
            {
                cur.next=cur.next.next;
                flag=true;
            }
            else if(flag)
            {
                cur=cur.next;
                prev.next=cur;
                flag=false;
            }
            else
            {
                prev=cur;
                cur=cur.next;
            }
        }
        if(flag)
            prev.next=cur.next;

        return dummy.next;
    }
}
