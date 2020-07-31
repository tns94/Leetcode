package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3405/
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][3];
        return maxProf(prices,0,-2,dp);
    }
    int maxProf(int[] prices,int index,int buyAmount, int[][] dp){

        if(index>prices.length-1)
            return 0;
        int flag=buyAmount==-2?2:(buyAmount==-1?1:0);
        if(flag!=0 && dp[index][flag]!=0)
            return dp[index][flag];

        int total=0;
        //If already bought
        if(buyAmount>=0)
        {
            total=Math.max( maxProf(prices,index+1,-1,dp)+(prices[index]-buyAmount),maxProf(prices,index+1,buyAmount,dp));
        }
        //If Yet to buy
        else if(buyAmount==-2)
        {
            total = Math.max(maxProf(prices,index+1,prices[index],dp),maxProf(prices,index+1,-2,dp));
        }
        //If cooldown period
        else if(buyAmount==-1)
            total = maxProf(prices,index+1,-2,dp);

        return dp[index][flag]=total;
    }
}
