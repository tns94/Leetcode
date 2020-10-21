package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3496/
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        rotate(nums,0,nums.length-1);
        rotate(nums,0,k-1);
        rotate(nums,k,nums.length-1);
    }
    void rotate(int[] nums, int start, int end)
    {
        int i=start,j=end;
        while (i<j)
        {
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        new RotateArray().rotate(nums,3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
