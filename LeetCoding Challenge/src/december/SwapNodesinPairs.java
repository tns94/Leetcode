package december;

import utils.ListNode;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3579/
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev=head;
        ListNode cur=head.next;

        while (cur != null)
        {
            int temp=cur.val;
            cur.val=prev.val;
            prev.val=temp;
            if(cur.next == null || cur.next.next == null)
                break;
            prev=cur.next;
            cur=prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
        new SwapNodesinPairs().swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))));
    }
}
