package october;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3518/
 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int max=1;
        int count=1;
        for (int i = 1; i < s.length(); i++) {
            count=(s.charAt(i - 1) == s.charAt(i))? count + 1: 1;
            max=Math.max(max,count);

        }
        return max;
    }
}
