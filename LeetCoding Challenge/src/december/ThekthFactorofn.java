package december;
/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3554/
 */
public class ThekthFactorofn {
    public int kthFactor(int n, int k) {
        int count=0;
        for (int i = 1; i <= n; i++) {
            if(n%i==0)
                count++;
            if(count==k)
                return i;
        }
        return -1;
    }
}
