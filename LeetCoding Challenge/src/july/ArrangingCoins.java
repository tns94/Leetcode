package july;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
 */
public class ArrangingCoins {

    //Binary Search Approach O(log(n))
    /*
    public int arrangeCoins(int n) {
        int left=0,right=n,mid;
        long sum=0;
        while(left<=right)
        {
            mid=left+(right-left)/2;

            sum=(((long)mid)*(mid+1))/2;
            if(n>sum)
            {
                left=mid+1;
                continue;
            }
            if(n<sum)
            {
                right=mid-1;
            }
            else
                return (int)mid;
        }
        return right;
    }*/

    //Using Sum of N Numbers Formula (n(n+1))/2 and completing the square technique
    //O(1)
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }

    public static void main(String[] args) {
        //test
        for (int i = 0; i < 25; i++) {
            System.out.println(i+"->"+new ArrangingCoins().arrangeCoins(i));
        }
    }
}
