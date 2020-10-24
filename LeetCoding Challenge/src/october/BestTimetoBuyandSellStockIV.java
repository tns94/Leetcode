package october;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3499/
 */
public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0)
            return 0;
        int days = prices.length;
        int[] arr1 = new int[days];
        int[] arr2 = new int[days];
        if (k >= prices.length) {
            return allTimeProfit(prices);
        }
        for (int i = 0; i < k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < days; j++) {
                arr2[j] = Math.max(arr2[j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, arr1[j] - prices[j]);
            }

            arr1 = arr2;
            arr2 = new int[days];

        }
        return arr1[days - 1];
    }

    public int allTimeProfit(int arr[]) {
        int profit = 0;
        int localMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] >= arr[i]) {
                localMin = arr[i];
            } else {
                profit += arr[i] - localMin;
                localMin = arr[i];
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockIV stockIV = new BestTimetoBuyandSellStockIV();
        System.out.println(stockIV.maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
