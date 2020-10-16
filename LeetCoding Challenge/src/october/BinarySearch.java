package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3488/
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while (i<=j)
        {
            int mid = i+((j-i)/2);
            if(target > nums[mid])
                i = mid+1;
            else if (target < nums[mid])
                j = mid-1;
            else
                return mid;
        }
        return -1;
    }
}
