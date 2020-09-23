package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3459/
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int prev=0;
        int prevToprev=0;
        int currentMax=0;
        for (int i = 0; i < nums.length; i++) {
            currentMax = Math.max(nums[i]+prevToprev,prev);
            prevToprev=prev;
            prev=currentMax;
        }
        return currentMax;
    }
}
