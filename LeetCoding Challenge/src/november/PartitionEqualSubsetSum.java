package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3545/
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums)
            sum+=i;
        if((sum&1)==1) return false;
        sum/=2;
        Boolean[][] dp=new Boolean[nums.length][sum+1];
        return isBipartite(nums,0,sum,dp);
    }
    boolean isBipartite(int[] nums, int index, int sum,Boolean[][] dp){
        if(index==nums.length || sum < 0)
            return false;
        if(sum==0)
            return true;
        if(dp[index][sum]!=null)
            return dp[index][sum];
        return dp[index][sum]= isBipartite(nums,index+1,sum,dp)  || isBipartite(nums,index+1,sum-nums[index],dp);
    }
}
