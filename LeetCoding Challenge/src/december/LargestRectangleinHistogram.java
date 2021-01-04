package december;

import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3587/
 */
public class LargestRectangleinHistogram {
    //O(n)
    public int largestRectangleArea(int[] heights) {
        int max=0;
        Stack<Integer> stack=new Stack<>();
        int i=0;
        while (i<heights.length)
        {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i++);
            else
            {
                int top=stack.pop();
                if(stack.isEmpty())
                {
                    max=Math.max(max,heights[top]*i);
                }
                else
                    max=Math.max(max,heights[top]*(i-stack.peek()-1));
            }
        }
        while (!stack.isEmpty())
        {
            int top=stack.pop();
            if(stack.isEmpty())
            {
                max=Math.max(max,heights[top]*i);
            }
            else
                max=Math.max(max,heights[top]*(i-stack.peek()-1));
        }
        return max;
    }
    /*O(n^2) solution
    public int largestRectangleArea(int[] heights) {
        int max=0;
        for (int i = 0; i < heights.length; i++) {
            int lowest=heights[i];
            for (int j = i; j < heights.length; j++) {
                lowest=Math.min(lowest,heights[j]);
                max=Math.max(max,lowest*(j-i+1));
            }
        }
        return max;
    }*/

    public static void main(String[] args) {
        LargestRectangleinHistogram l=new LargestRectangleinHistogram();
        System.out.println(l.largestRectangleArea(new int[]{5}));
    }
}
