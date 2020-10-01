package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3461/
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        return s.length()-s.lastIndexOf(" ")-1;
    }
}
