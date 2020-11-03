package october;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3517/
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead=new ListNode();
        ListNode cur=head,prev,next;
        while (cur!=null)
        {
            prev=newHead;
            next=newHead.next;
            while (next != null)
            {
                if(cur.val < next.val)
                    break;
                prev=next;
                next=next.next;
            }
            ListNode curNext=cur.next;
            cur.next=next;
            prev.next=cur;
            cur=curNext;

        }
    return newHead.next;
    }

    public static void main(String[] args) {
        InsertionSortList insertionSortList=new InsertionSortList();
        ListNode node=new ListNode(-1,new ListNode(5,new ListNode(3,new ListNode(4,new ListNode(0)))));
        insertionSortList.insertionSortList(node);
    }
    
    static class ListNode {
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
}
