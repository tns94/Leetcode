package april21;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3705/
 */
public class BeautifulArrangementII {
    public static int[] constructArray(int n, int k) {
        int[] ans=new int[n];
        int min=1,max=k+1;
        int i=0;
        while (i <= k)
        {
                ans[i] = (i&1) == 0 ? min++:max--;
                i++;
        }
        int num= k+2;
        while (i < n)
        {
            ans[i++] = num++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.stream(constructArray(3,2)).asLongStream().forEach(System.out::print);
    }
}
