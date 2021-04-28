package march21;

import utils.ListNode;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3671/
 */
public class SwappingNodesinaLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow =head;

        ListNode swap1, swap2;
        for(int i=0; i<k-1; i++){
            fast = fast.next;
        }
        swap1 = fast;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        swap2 = slow;
        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;
        return head;
    }
}
