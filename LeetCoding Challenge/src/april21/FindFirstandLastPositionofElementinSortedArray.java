package april21;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] array = new int[] {-1, -1};
        if (nums.length == 0) return array;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid;
        }
        if (nums[i] != target) return array;
        array[0] = i;

        j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2 + 1;
            if (nums[mid] > target)
                j = mid - 1;
            else
                i = mid;
        }
        array[1] = j;
        return array;
    }
}
