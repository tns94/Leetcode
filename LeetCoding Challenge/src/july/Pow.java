package july;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3392/
 */
public class Pow {
    public double myPow(double x, int n) {
        double ans= power(x,n);
        if(n<0)
            return 1/ans;
        return ans;
    }
    double power(double a,int b)
    {
        if(b==0)
            return 1;
        double val=power(a,b/2);
        double ans= val * val;
        if(b%2!=0)
            ans = ans * a;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.1,3));
    }
}
