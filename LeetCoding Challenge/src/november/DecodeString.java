package november;

import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3536/
 */
public class DecodeString {
    public String decodeString(String s) {
        int n = s.length();
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                count.push(num);
                stack.push(cur);
                num = 0;
                cur = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = cur;
                cur = stack.pop();
                int counts = count.pop();
                while (counts-- > 0) {
                    cur.append(tmp);
                }
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
    public static void main(String[] args) {
        DecodeString decodeString=new DecodeString();
        decodeString.decodeString("3[a2[c]]");
    }
}
