package january21;

import utils.ListNode;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3615/
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists,  int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];
        if (left + 1 == right) return mergeTwoLists(lists[left], lists[right]);
        int mid = left + (right - left) / 2;
        ListNode nd1 = mergeKLists(lists, left, mid);
        ListNode nd2 = mergeKLists(lists, mid + 1, right);
        return mergeTwoLists(nd1, nd2);
    }

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
