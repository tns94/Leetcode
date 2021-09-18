package april21;

import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3699/
 */
public class DetermineifStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int len=s.length();
        char[] arr=s.toCharArray();
        return getVowelCount(arr,0,len/2) == getVowelCount(arr,len/2,len);
    }
    int getVowelCount(char[] arr, int start, int end)
    {
        List<Character> vowels= Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        int count=0;
        while (start < end)
        {
            if(vowels.contains(arr[start++]))
                count++;
        }
        return count;
    }
}
