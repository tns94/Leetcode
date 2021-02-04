package january2021;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/583/week-5-january-29th-january-31st/3623/
 */
public class NextPermutation {
    void reverse(int[] nums,int i,int j){
        while (i<j)
        {
            int temp=nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
        }
    }
    int binarySearch(int[] nums,int s,int e,int k)
    {
        int in=-1;
        while (s<=e)
        {
            int mid = s + (e -s)/2 ;
            if(nums[mid] > k)
            {
                s = mid+1;
                if(in == -1 || nums[in] >= nums[mid])
                    in= mid;
            }
            else
                e = mid -1;
        }
        return in;
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1])
            i--;
        if(i < 0)
        {
            reverse(nums,0,nums.length-1);
            return;
        }
        int in= binarySearch(nums,i+1,nums.length-1,nums[i]);
        int temp=nums[i];
        nums[i]=nums[in];
        nums[in]=temp;
        reverse(nums,i+1,nums.length-1);
    }

    public static void main(String[] args) {
        NextPermutation n=new NextPermutation();
        int[] nums={1,2,3};
        n.nextPermutation(nums);
        System.out.println();
    }
}
