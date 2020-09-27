package september;
/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3471/
 */
public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        char totalXor = t.charAt(t.length() - 1);

        for (int i = 0; i < s.length(); i++) {
            totalXor ^= s.charAt(i);
            totalXor ^= t.charAt(i);
        }

        return totalXor;
    }

    public static void main(String[] args) {
        FindtheDifference findtheDifference=new FindtheDifference();
        System.out.println(findtheDifference.findTheDifference("abcd","abcde"));

    }
}
