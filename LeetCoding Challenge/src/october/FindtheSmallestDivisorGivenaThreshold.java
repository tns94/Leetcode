package october;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3521/
 */
public class FindtheSmallestDivisorGivenaThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo=1,hi=(int)1e6;
        while (lo<=hi)
        {
            int mid=((hi-lo)/2)+lo;
            int sum=sumAfterDivision(nums,mid);

            if(sum>threshold)
                lo=mid+1;
            else
                hi=mid-1;
        }
        return hi+1;
    }
    int sumAfterDivision(int[] nums, int divisor)
    {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=(nums[i]+divisor-1)/divisor;
        }
        return sum;
    }
}
