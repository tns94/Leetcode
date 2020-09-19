package september;
/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3464/
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int minPriceTillNow = prices[0];
        int maxProfitTillNow = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfitTillNow = Math.max(prices[i] - minPriceTillNow, maxProfitTillNow);
            minPriceTillNow = Math.min(minPriceTillNow, prices[i]);
        }
        return maxProfitTillNow;
    }
}
