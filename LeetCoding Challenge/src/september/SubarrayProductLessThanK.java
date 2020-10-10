package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3475/
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int counter=0;
        long product=1;
        for (int j=0,i = 0;j< nums.length; j++) {

            product *= nums[j];

            while (i < j && product >= k)
                product /= nums[i++];

            if(product < k)
                counter += j - i + 1;
        }
        return counter;
    }
}
