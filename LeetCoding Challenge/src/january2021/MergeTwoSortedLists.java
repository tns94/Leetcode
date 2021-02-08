package january2021;

import utils.ListNode;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3592/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode cur=dummy;
        ListNode cur1=l1;
        ListNode cur2=l2;

        while (cur1 != null && cur2 != null)
        {
            if(cur1.val > cur2.val)
            {
                cur.next=cur2;
                cur2=cur2.next;
            }
            else
            {
                cur.next=cur1;
                cur1=cur1.next;
            }
            cur=cur.next;
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return dummy.next;
    }
}
