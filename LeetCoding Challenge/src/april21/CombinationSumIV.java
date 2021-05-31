package april21;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp= new Integer[target+1];
       return combinationSum(nums,target,dp);
    }
    int combinationSum(int[] nums, int target,Integer[] dp)
    {

        if(target < 0)
            return 0;
        if(target == 0)
            return 1;
        if(dp[target] != null)
            return dp[target];
        int combinations=0;
        for (int i = 0; i < nums.length; i++) {
            combinations += combinationSum(nums,target - nums[i],dp);
        }
        return dp[target]=combinations;
    }
}
