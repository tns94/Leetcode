package march21;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3668/
 */
public class CoinChange {
    int coinChangeDP(int[] coins, int amount, Integer[] dp) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (dp[amount] != null)
            return dp[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeDP(coins, amount - coin, dp);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        return dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
    }
    public int coinChange(int[] coins, int amount) {
        int ans = coinChangeDP(coins, amount, new Integer[amount + 1]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    /*
      public int coinChange(int[] coins, int amount) {
          int max = amount + 1;
          int[] dp = new int[amount + 1];
          Arrays.fill(dp, max);
          dp[0] = 0;
          for (int i = 1; i <= amount; i++) {
              for (int j = 0; j < coins.length; j++) {
                  if (coins[j] <= i) {
                      dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                  }
              }
          }
          return dp[amount] > amount ? -1 : dp[amount];
      }

     */


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{2}, 3));
    }
}
