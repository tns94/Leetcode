package february21;
/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3636/
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] co= new char[26];
        for(char ch:s.toCharArray())
            co[ch-97]++;
        for (char ch:t.toCharArray())
            co[ch-97]--;
        for(int i:co)
            if (i>0)
                return false;
        return true;
    }
}
