package august;

import java.util.Arrays;

/*
https://leetcode.com/submissions/detail/379398126/?from=/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3420/
 */
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int lo=0,hi=citations.length-1,mid;
        int max=0;
        while (hi>=lo)
        {
            mid=((hi-lo)/2)+lo;
            int len=(citations.length-mid);
            if(citations[mid]>=len)
            {
                max=Math.max(len,max);
                hi=mid-1;
            }else
            {
                lo=mid+1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{4,1,2,7,5,3,1}));
    }
}
