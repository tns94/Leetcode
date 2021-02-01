package january21;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3595/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] index=new int[256];
        Arrays.fill(index,-1);
        int max=0;
        int co=0;
        for (int i = 0; i < s.length(); i++) {
            int ch=s.charAt(i);
            if(index[ch] != -1 && (i-co) <= index[ch] )
            {
                max=Math.max(max,co);
                co=i-index[ch];
            }
            else {
                co++;
            }
            index[ch] = i;

        }
        return Math.max(max,co);
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l=new LongestSubstringWithoutRepeatingCharacters();
        String s="abcabcbb";
        System.out.println(l.lengthOfLongestSubstring(s));
    }
}
