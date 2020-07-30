package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3402/
 */

public class AddDigits {
    public int addDigits(int num) {
        if(num==0)
            return 0;
        /*
        Formula used
        1+((number-1)%(base-1))
        */
        return 1+((num-1)%9);
    }
}