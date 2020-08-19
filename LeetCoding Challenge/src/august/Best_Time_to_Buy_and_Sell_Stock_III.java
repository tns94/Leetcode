package august;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3426/
 */

public class Best_Time_to_Buy_and_Sell_Stock_III {
    int maxProfit(int[] prices, int index,int buy,int trasactions,Map<String,Integer> dp)
    {
        if(index==prices.length)
            return 0;
        if(trasactions==2)
            return 0;

        String key=index+""+buy+""+trasactions;
        if(dp.containsKey(key))
            return dp.get(key);

        if(buy>=0)
        {
            int ans=Math.max(maxProfit(prices,index+1,-1,trasactions+1,dp)+(prices[index]-buy),maxProfit(prices,index+1,buy,trasactions,dp));
            dp.put(key,ans);
            return ans;
        }
        else
        {
            int ans=Math.max(maxProfit(prices,index+1,prices[index],trasactions,dp),maxProfit(prices,index+1,buy,trasactions,dp));
            dp.put(key,ans);
            return ans;
        }

    }
    public int maxProfit(int[] prices) {
        Map<String,Integer> dp=new HashMap<>();

        return maxProfit(prices,0,-1,0,dp);
    }

    public static void main(String[] args) {
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_III().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

  /*  public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }*/
}
