package july;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3404/
 */

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];
        for(char t : tasks)
            count[t - 'A']++;

        Arrays.sort(count);
        int t = 25;

        while(t >= 0 && count[t] == count[25])
            t--;

        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - t);
    }
}
