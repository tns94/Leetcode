package october;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3490/
 */
public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length==0)
            return 0;

        Arrays.sort(points,(o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else {
                return -1;
            }
        });

        int[] prev=points[0];
        int counter=0;
        for (int i = 1; i < points.length; i++) {
            int[] cur=points[i];
            if(cur[0] <= prev[1])
            {

                counter++;
                cur[1]=prev[1];
            }
            prev=cur;
        }
        return points.length-counter;
    }

    public static void main(String[] args) {
        MinimumNumberofArrowstoBurstBalloons m=new MinimumNumberofArrowstoBurstBalloons();
        System.out.println(m.findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}));
    }
}
