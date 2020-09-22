package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3467/
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timeLine=new int[1001];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int[] trip:trips)
        {
            timeLine[trip[1]] += trip[0]; // Boarding Passenger
            timeLine[trip[2]] -= trip[0]; // UnBoarding Passenger
            min=Math.min(min,trip[1]);
            max=Math.max(max,trip[2]);
        }
        int total=0;
        for (int i = min; i <= max; i++) {
            total += timeLine[i];
            if(total > capacity)
                return false;
        }
        return true;
    }
}
