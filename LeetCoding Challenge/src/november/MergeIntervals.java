package november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3535/
 */
public class MergeIntervals {
    public  static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        List<int[]> list=new ArrayList<>();
        int[] prev=intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(prev[1]>= intervals[i][0])
            {
                prev[1]=Math.max(intervals[i][1],prev[1]);
                intervals[i]=null;
            }
            else prev=intervals[i];
        }
        for (int[] in:intervals)
        {
            if(in!=null)
                list.add(in);
        }
        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        merge(new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}});
    }
}
