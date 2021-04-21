package march21;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3687/
 */
public class ReconstructOriginalDigitsfromEnglish {
    public static String originalDigits(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 97]++;
        }

        int[] digitFreq = new int[10];

        digitFreq[0] = counter['z' - 97];
        digitFreq[6] = counter['x' - 97];
        digitFreq[4] = counter['u' - 97];
        digitFreq[2] = counter['w' - 97];
        digitFreq[8] = counter['g' - 97];
        digitFreq[5] = counter['f' - 97] - digitFreq[4];
        digitFreq[7] = counter['s' - 97] - digitFreq[6];
        digitFreq[1] = counter['o' - 97] - digitFreq[0] - digitFreq[2] - digitFreq[4];
        digitFreq[3] = counter['t' - 97] - digitFreq[8] - digitFreq[2];
        digitFreq[9] = counter['i' - 97] - digitFreq[5] - digitFreq[6] - digitFreq[8];

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int freq = digitFreq[i];
            while (freq-- > 0)
                ans.append(i);

        }
        return ans.toString();
    }
}
