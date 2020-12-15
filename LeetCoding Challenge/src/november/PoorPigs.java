package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3530/
 */
public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int T=(minutesToTest / minutesToDie) + 1;
        return  customLog(T,buckets);
    }
    private int customLog(double base, double logNumber) {
        return ceil(Math.log(logNumber) / Math.log(base));
    }
    int ceil(double number)
    {
        int numFloor=((int)number);
        return numFloor==number?numFloor:numFloor+1;
    }
}
