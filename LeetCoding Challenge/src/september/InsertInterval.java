package september;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3458/
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int index = 0;
        for (int[] curr : intervals) {
            if (curr[0] > newInterval[1] || curr[1] < newInterval[0]) {
                list.add(curr);
                if (curr[0] < newInterval[0])
                    index++;
            } else {
                newInterval[0] = Math.min(curr[0], newInterval[0]);
                newInterval[1] = Math.max(curr[1], newInterval[1]);
            }
        }
        list.add(index, newInterval);
        return list.toArray(new int[0][0]);
    }
}
