package december;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3565/
 */
public class PalindromePartitioning {

    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        dfs(0,new ArrayList<>(),s,dp);
        return result;
    }
    void dfs(int start, ArrayList<String> current,String s,boolean[][] dp)
    {
        if(s.length()<=start) result.add(new ArrayList<>(current));
        for (int i = start; i < s.length(); i++) {
            if(s.charAt(start) == s.charAt(i) && (i-start <= 2 || dp[start+1][i-1] ) )
            {
                dp[start][i]=true;
                current.add(s.substring(start,i+1));
                dfs(i+1,current,s,dp);
                current.remove(current.size()-1);
            }
        }
    }
}
