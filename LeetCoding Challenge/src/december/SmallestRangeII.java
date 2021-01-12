package december;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3573/
 */
public class SmallestRangeII {
    public int smallestRangeII(int[] A, int K){
        Arrays.sort(A);
        int len=A.length-1;
        int minDiff=A[len] - A[0];
        for (int i = 0; i < len; i++) {
            int a=A[i];
            int b=A[i+1];
            int max=Math.max(A[len]-K,a+K);
            int min=Math.min(A[0]+K,b-K);
            minDiff=Math.min(minDiff,max-min);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        new SmallestRangeII().smallestRangeII(new int[]{1,3,6,65,3,4,34,5},3);
    }
}
