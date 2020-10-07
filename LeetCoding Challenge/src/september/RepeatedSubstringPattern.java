package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3447/
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for (int i = l / 2; i > 0; i++) {
            if (l % i == 0) {
                int repeated = l / i;
                String substr = s.substring(0, i);
                StringBuilder stringBuilder = new StringBuilder();

                while (repeated-- > 0)
                    stringBuilder.append(substr);
                if (stringBuilder.toString().equals(s)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        new RepeatedSubstringPattern().repeatedSubstringPattern("abab");
    }
}
