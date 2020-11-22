package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3493/
 */
public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getmid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (left != null && right != null) {
            if (left.val > right.val) {
                tail.next = right;
                right = right.next;
            } else {
                tail.next = left;
                left = left.next;
            }
            tail = tail.next;
        }
        tail.next = left == null ? right : left;
        return head.next;
    }

    ListNode getmid(ListNode head) {
        ListNode mid = null;
        while (head != null && head.next != null) {
            mid = mid == null ? head : mid.next;
            head = head.next.next;
        }
        ListNode midNext = mid.next;
        mid.next = null;
        return midNext;
    }
}
