package november;
/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1,mid;
        while (left<=right)
        {
            mid=(right-left)/2+left;
            if(nums[mid]==target)
                return mid;
            if(nums[mid] >= nums[left]) {
                if (nums[mid] > target && nums[left] <= target)
                    right = mid - 1;
                else left = mid + 1;
            }
            else {
                if (nums[mid] < target && nums[right] >= target)left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
