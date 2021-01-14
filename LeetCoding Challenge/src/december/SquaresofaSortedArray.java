package december;


/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3567/
 */
public class SquaresofaSortedArray {
    //O( n log(n) ) Solution
    /*
      public int[] sortedSquares(int[] nums) {
            int[] ret=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i]=nums[i]*nums[i];
        }
        Arrays.sort(ret);
        return ret;
    }
     */

    //O(n) Solution
    public int[] sortedSquares(int[] nums) {
        int firstNonNegative=-1;
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i]>=0)
            {
                firstNonNegative=i;
                break;
            }
        }

        if(firstNonNegative>0)
        {
            int[] neg=new int[firstNonNegative];
            int[] pos=new int[len-firstNonNegative];
            for (int i = 0; i < firstNonNegative ; i++) {
                neg[i]=nums[i]*nums[i];
            }
            for (int i = firstNonNegative; i < len; i++) {
                pos[i-firstNonNegative]=nums[i]*nums[i];
            }
            int[] ret = new int[len];
            int i=firstNonNegative-1,j=0,k=0;
            while (i>=0 && j < pos.length)
            {
                if(neg[i]<pos[j])
                    ret[k]=neg[i--];
                else
                    ret[k]=pos[j++];
                k++;
            }
            for (int l = i; l >= 0; l--) {
                ret[k++]=neg[l];
            }
            for (int l = j; l < pos.length; l++) {
                ret[k++]=pos[l];
            }
            return ret;
        }
        else {
            int[] ret = new int[len];
            if(firstNonNegative==-1){
                for (int i = len-1; i >= 0; i--) {
                    ret[len-1-i] = nums[i] * nums[i];
                }
            }
            else
            {
                for (int i = 0; i < len; i++) {
                    ret[i] = nums[i] * nums[i];
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        SquaresofaSortedArray s=new SquaresofaSortedArray();
        s.sortedSquares(new int[]{-2,0});

    }
}
