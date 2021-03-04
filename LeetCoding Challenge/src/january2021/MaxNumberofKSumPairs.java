package january2021;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3608/
 */
public class MaxNumberofKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        int co=0;
        while (i<j)
        {
            if(nums[i]+nums[j] > k)
                j--;
            else if(nums[i]+nums[j] < k)
                i++;
            else
            {
                co++;
                i++;j--;
            }
        }
        return co;
    }
}
