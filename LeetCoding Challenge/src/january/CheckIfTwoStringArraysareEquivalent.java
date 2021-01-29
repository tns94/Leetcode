package january;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3597/
 */
public class CheckIfTwoStringArraysareEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        for (String i : word1)
        {
            string1.append(i);
        }

        for (String i : word2)
        {
            string2.append(i);
        }

        return string1.equals(string2);
    }
}
