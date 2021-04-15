package march21;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3660/
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet();
        ListNode cur=headA;
        while (cur != null)
        {
            set.add(cur);
            cur=cur.next;
        }
        cur=headB;
        while (cur != null)
        {
            if(set.contains(cur))
                return cur;
            cur = cur.next;
        }
        return null;
    }
}
