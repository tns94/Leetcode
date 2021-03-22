package february21;
/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3625/
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int co=0;
        while(n != 0)
        {
            co++;
            n &= (n-1);
        }
        return co;
    }
}
