package august;

import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3430/
 */
public class ReorderList {


    static public class ListNode {
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

    public void reorderList(ListNode head) {
        if(head==null)
            return;
        Stack<ListNode> stack=new Stack<>();
        ListNode cur=head;
        while (cur!=null)
        {
            stack.push(cur);
            cur=cur.next;
        }
        cur=head;

        ListNode pop=null;
        while ((pop)!=cur)
        {
            pop=stack.pop();
            if(pop==cur)
                break;
            ListNode temp=cur.next;
            cur.next= pop;
            cur.next.next=temp;
            cur=temp;
        }
        cur.next=null;
    }
/*
    public static void main(String[] args) {

        ListNode list5=new ListNode(5);
        ListNode list4=new ListNode(4,list5);
        ListNode list3=new ListNode(3,list4);
        ListNode list2=new ListNode(2,list3);
        ListNode list1=new ListNode(1,list2);
        new ReorderList().reorderList(list1);
        System.out.println();

    }*/

}
