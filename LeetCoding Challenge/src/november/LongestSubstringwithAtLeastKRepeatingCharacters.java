package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3544/
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        int[] charCount=new int[26];
        int max=0;
        int start=0;
        boolean valid=true;
        for(char c: s.toCharArray()) ++charCount[c-97];

        for (int i = 0; i < s.length(); i++) {
            if(charCount[s.charAt(i)-97] >0 && charCount[s.charAt(i)-97] < k )
            {
                String str=s.substring(start,i);
                max=Math.max(max,longestSubstring(str,k));
                start=i+1;
                valid=false;

            }
        }
        if(valid)
            return s.length();
        else
            return Math.max(max,longestSubstring(s.substring(start),k));
    }
}
