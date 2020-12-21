package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3543/
 */
public class SmallestIntegerDivisiblebyK {
    public int smallestRepunitDivByK(int K) {
        if(K==2 || K==5)
            return -1;
        int num=0;
        int len=K;
        while (len-->0)
        {
            num = (num * 10 + 1)%K;
            if(num == 0)
                return K-len;
        }
        return -1;
    }
}
