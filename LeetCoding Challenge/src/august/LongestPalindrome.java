package august;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[123];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int answer = 0;
        for (int i = 0; i < 123; i++) {
            answer += (count[i] & ~1); // clearing lsb
        }
        return answer < s.length() ? answer + 1 : answer;
    }
}