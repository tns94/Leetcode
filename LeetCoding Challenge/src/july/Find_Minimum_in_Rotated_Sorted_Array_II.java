package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3401/
 */

/*
O(n) Solution 
 */
public class Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] nums) {

        int previous=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<previous)
                return nums[i];
            previous=nums[i];
        }
        return previous;

    }
}
