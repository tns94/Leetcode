package october;
/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3462/
 */
public class ComplementofBase10Integer {
    public int bitwiseComplement(int N) {
        //count of bits in N
        int count=(int)(Math.log(N)/Math.log(2))+1;
        int mask=1<<count;
        mask--;
        return N ^ mask;
    }
}
