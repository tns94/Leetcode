package october;

import java.util.Stack;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3505/
 */
public class _132Pattern {
    public static boolean find132pattern(int[] nums) {
        if(nums==null|| nums.length<3)
            return false;
        int[] minArray = new int[nums.length];
        minArray[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            minArray[i] = Math.min(minArray[i-1],nums[i]);
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(nums[nums.length-1]);
        for (int i = nums.length-2; i > 0 ; i--) {
            if(nums[i] > minArray[i])
            {
                while (!stack.isEmpty() && stack.peek() <= minArray[i])
                    stack.pop();
                if(!stack.isEmpty() && stack.peek() < nums[i])
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        find132pattern(new int[]{1,4,0,-1,-2,-3,-1,-2});
    }
}

