package october;

import java.util.Arrays;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3482/
 */
public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        if(nums.length<2)
            return 0;
        Arrays.sort(nums);
        int counter=0;
        int i=0,j=1;
        int length=nums.length;
        while (i<length && j< length)
        {
            int numi=nums[i];
            int numj=nums[j];
            int diff=numj-numi;

            if(diff == k)
            {
                counter++;
                while (i<length && nums[i]==numi) i++;
                while (j<length && nums[j]==numj) j++;
            }
            else if(diff < k)
            {
                while (j<length && nums[j]==numj) j++;
            }
            else
            {
                while (i<length && nums[i]==numi) i++;
            }
            if(i==j)
                j++;
        }
        return counter;
    }

    public static void main(String[] args) {
        KdiffPairsinanArray kdiffPairsinanArray=new KdiffPairsinanArray();
        System.out.println(kdiffPairsinanArray.findPairs(new int[]{1,2,3,4,5},1));
    }
}
