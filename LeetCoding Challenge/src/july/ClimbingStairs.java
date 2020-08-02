package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3407/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {



        //Iterative
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];

        return dp[n];

        //recursive
        //return climb(n,0,dp);

    }
    int climb(int n,int step,int[] dp)
    {
        if(step==n)
            return 1;
        if(step>n)
            return 0;
        if(dp[step]!=0)
            return dp[step];
        return dp[step]=climb(n,step+1,dp)+climb(n,step+2,dp);
    }
}
