package march21;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3658/
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] ret=new int[2];
        for (int i = 0; i < nums.length; i++) {
            int in=Math.abs(nums[i])-1;
            if(nums[in]<0)
                ret[0]=Math.abs(nums[i]);
            else
                nums[in]=-nums[in];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                ret[1]=i+1;
                break;
            }
        }
        return ret;
    }
}
