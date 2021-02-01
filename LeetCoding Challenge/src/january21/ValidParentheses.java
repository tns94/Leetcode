package january21;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3610/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');


        for (char ch:s.toCharArray()){
            if(map.containsKey(ch))
            {
                if(stack.isEmpty() || stack.peek() != map.get(ch))
                    return false;
                stack.pop();
            }
            else
                stack.push(ch);
        }
        return stack.isEmpty();
    }
}
