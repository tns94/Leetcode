package october;

import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3522/
 */

// Without Reversing LinkedList
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode cur = l1;
        while (cur != null) {
            stack1.push(cur);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            stack2.push(cur);
            cur = cur.next;
        }
        int carry = 0;
        ListNode temp = new ListNode();
        cur = temp;
        int sum = 0;
        while (stack1.size()>0 || stack2.size()>0 || carry >0) {
            sum = getValue(stack1) + getValue(stack2) + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.val = sum;
            temp = new ListNode();
            temp.next = cur;
            cur = temp;
        }
        return cur.next;

    }
    int getValue(Stack<ListNode> stack)
    {
        if(stack.isEmpty())
            return 0;
        else return stack.pop().val;
    }
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
}
