package march21;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3676/
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int[] diff = new int[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            diff[i-1] = nums[i] - nums[i-1];
        }
        return Math.max(sub(diff,false),sub(diff,true));
    }
    int sub(int[] diff,boolean positive)
    {
        int co=0;
        for (int i = 0; i < diff.length; i++) {
            if(positive){
                if(diff[i]>0)
                {
                    positive = !positive;
                    co++;
                }
            }
            else{
                if(diff[i]<0)
                {
                    positive = !positive;
                    co++;
                }
            }

        }
        return co+1;
    }
}
