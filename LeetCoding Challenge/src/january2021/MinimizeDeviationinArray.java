package january2021;

import java.util.PriorityQueue;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/583/week-5-january-29th-january-31st/3622/
 */
public class MinimizeDeviationinArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        for (int a : nums) {
            if (a % 2 == 1) a *= 2;
            queue.add(-a);
            min = Math.min(min, a);
        }
        int ans = Integer.MAX_VALUE;
        while (true) {
            int a = -queue.poll();
            ans = Math.min(ans, a - min);
            if (a % 2 == 1) break;
            min = Math.min(min, a / 2);
            queue.add(-a / 2);
        }
        return ans;
    }

}
