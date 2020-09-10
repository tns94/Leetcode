package august;
/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3412/
 */
public class Power_of_Four {
    public boolean isPowerOfFour(int num) {

        for(int i=0;i<32;i+=2)
            if(1<<i==num)
                return true;
        return false;
    }

}
