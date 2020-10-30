package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3494/
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else
        return Math.max(robHelper(nums,0,nums.length-1),robHelper(nums,1,nums.length));
    }
    int robHelper(int[] nums,int start, int end)
    {
        int prev=0;
        int prevToprev=0;
        int currentMax=0;
        int n=nums.length;
        for (int i = start; i < end; i++) {
            currentMax = Math.max(nums[i]+prevToprev,prev);
            prevToprev=prev;
            prev=currentMax;
        }
        return currentMax;
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII=new HouseRobberII();
        System.out.println(houseRobberII.rob(new int[]{2,3,2}));
    }
}
