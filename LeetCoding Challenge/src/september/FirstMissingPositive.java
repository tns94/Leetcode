package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/558/week-5-september-29th-september-30th/3478/
 */

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int i=0,j=nums.length-1;
        while (i<=j)
        {
            while (i<nums.length && nums[i]>0) i++;
            while (j>0 && nums[j]<=0) j--;
            if(i>=j)break;
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }

        for (int k = 0; k < i; k++) {

            int num=Math.abs(nums[k]);
            if(num<=i && num>0 && nums[num-1]>0)
            {
                nums[num-1]=-nums[num-1];
            }
        }
        for (int k = 0; k < i; k++) {
            if(nums[k]>0)
                return k+1;
        }
        return i+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive=new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1,1}));
    }
}
