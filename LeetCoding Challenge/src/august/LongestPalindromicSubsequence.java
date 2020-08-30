package august;

/*
https://leetcode.com/problems/longest-palindromic-subsequence/submissions/
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) dp[i][i] = 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1, k = 0; j < s.length(); j++, k++) {
                if (s.charAt(k) == s.charAt(j))
                    dp[k][j] = 2 + dp[k + 1][j - 1];
                else
                    dp[k][j] = Math.max(dp[k][j - 1], dp[k + 1][j]);
            }
        }

        return dp[0][s.length() - 1];

    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));

    }
}
