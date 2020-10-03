package september;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3469/
 */

/*
Constraints
O(1) Space
O(n) Time
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int count1=0;
        int count2=0;

        int maxOne=-1;
        int maxTwo=-1;

        for(int n:nums)
        {
            if(maxOne==n)
                count1++;
            else if(maxTwo == n)
                count2++;
            else if(count1 == 0)
            {
                maxOne=n;
                count1++;
            }
            else if(count2==0)
            {
                maxTwo = n;
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        count1=count2=0;

        for(int n:nums)
        {
            if(n==maxOne)count1++;
            if(n==maxTwo)count2++;
        }

        int moreThan=nums.length/3;

        if(count1>moreThan) list.add(maxOne);
        if(count2>moreThan) list.add(maxTwo);

        return list;
    }
}
