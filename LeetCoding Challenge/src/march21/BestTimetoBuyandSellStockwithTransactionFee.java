package march21;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3674/
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
    static public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int h=hold + prices[i] - fee;
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1,3,2,8,4,9},2);
    }
}
