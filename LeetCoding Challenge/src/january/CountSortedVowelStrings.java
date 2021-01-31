package january;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3607/
 */
public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        Integer[][] dp=new Integer[5][n];
       return count(n,0,0,dp);
    }
    int count(int n,int current,int length, Integer[][] dp)
    {
        if(length>n)
            return 0;
        if(n==length)
            return 1;
        if(dp[current][length]!=null)
            return dp[current][length];
        int co=0;
        for (int i = current; i < 5; i++) {
            co+=count(n,i,length+1,dp);
        }
        return dp[current][length]=co;
    }

    public static void main(String[] args) {
        CountSortedVowelStrings c=new CountSortedVowelStrings();
        System.out.println(c.countVowelStrings(50));
    }
}
