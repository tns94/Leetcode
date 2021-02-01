package january21;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3609/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int left=0;
        int right=0;

        for (int i = 0; i < s.length(); i++) {
            int len=Math.max(
                    expand(s,i,i),
                    expand(s,i,i+1)
            );
            if(len > right-left)
            {
                left = i - (len - 1) / 2;
                right = i + len /2;
            }
        }
        return s.substring(left,right+1);
    }
    int expand(String s,int left,int right)
    {
        int L=left,R=right;
        while (L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
