package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3396/
 */
public class RemoveLinkedListElements {

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


    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        while(head!=null && head.val==val)
         head=head.next;


        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2,l1);
        ListNode l3=new ListNode(2,l2);
        ListNode l4=new ListNode(1,l3);
        ListNode l5=new ListNode(4,l4);
        ListNode l6=new ListNode(5,l5);
        ListNode l7=new ListNode(6,l6);
        ListNode l8=new RemoveLinkedListElements().removeElements(l7,6);
        System.out.println();
    }

}
