package march21;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3659/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        for(int num:nums)
        {
            actualSum += num;
        }

        int n = nums.length+1;
        int expectedSum = n * (n-1)/2;

        return expectedSum - actualSum;
    }
}
