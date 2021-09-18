package april21;
/*
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3709/
 */
public class FibonacciNumber {
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int a = 0;
        int b = 1;
        int sum = 0;
        while((n-2)>=0)
        {
            sum = a + b;
            a = b;
            b = sum;
            n--;
        }
        return sum;

    }
}
