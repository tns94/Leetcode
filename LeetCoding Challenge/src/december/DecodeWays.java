package december;
/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3581/
 */
class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int ans1 = 1;
        int ans2 = 0;
        for (int i = n-1; i >= 0; i--) {
            int dp = s.charAt(i) == '0' ? 0 : ans1;
            if (i < n-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <= '6')) {
                dp += ans2;
            }
            ans2 = ans1;
            ans1 = dp;
        }
        return ans1;
    }
}
