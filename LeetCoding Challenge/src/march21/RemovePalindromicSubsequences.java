package march21;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3665/
 */
public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if(s.length()==0)
            return 0;
        if(isPalindrome(s))
            return 1;
        else return 2;
    }
    boolean isPalindrome(String s)
    {
        int i=0,j=s.length()-1;
        while (i<j)
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        return true;
    }
}
