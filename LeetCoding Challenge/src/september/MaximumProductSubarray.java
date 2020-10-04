package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3456/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currentMin=nums[0];
        int currentMax=nums[0];
        int max=nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>0)
            {
                currentMax=Math.max(nums[i],currentMax*nums[i]);
                currentMin=Math.min(currentMin*nums[i],nums[i]);
            }
            else{
                int temp=currentMax;
                currentMax=Math.max(nums[i],currentMin*nums[i]);
                currentMin=Math.min(temp*nums[i],nums[i]);
            }
            max = Math.max(max,currentMax);
        }

        return max;
    }
    public static void main(String[] args) {
        new MaximumProductSubarray().maxProduct(new int[]{2,-5,-2,-4,3});
    }
}
