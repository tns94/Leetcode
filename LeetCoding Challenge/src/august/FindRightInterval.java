package august;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3438/
 */

public class FindRightInterval {
    int binarySearch(List<Interval> intervalList, int start, int end, int min, int index) {
        if (start > end)
            return index;

        int mid = ((end - start) / 2) + start;
        Interval interval = intervalList.get(mid);
        if (interval.start == min)
            return interval.index;
        else if (interval.start > min)
            return binarySearch(intervalList, start, mid - 1, min, interval.index);
        else
            return binarySearch(intervalList, mid + 1, end, min, index);
    }

    public int[] findRightInterval(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1], i));
        }
        intervalList.sort((o1, o2) -> o1.start != o2.start ? o1.start - o2.start : o1.end - o2.end);
        int[] answer = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervalList.get(i);
            answer[interval.index] = binarySearch(intervalList, i + 1, intervals.length - 1, interval.end, -1);
        }
        return answer;
    }

    static class Interval {
        int start, end, index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {2, 3}, {0, 1}, {3, 4}};//{1,12},{2,9},{3,10},{13,14},{15,16},{16,17}
        int[] output = new FindRightInterval().findRightInterval(input);
        for (int i = 0; i < output.length; i++) System.out.println(output[i]);
    }
}
