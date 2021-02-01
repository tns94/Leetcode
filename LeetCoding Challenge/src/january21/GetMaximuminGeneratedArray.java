package january21;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3605/
 */
public class GetMaximuminGeneratedArray {
    public int getMaximumGenerated(int n) {
        if(n==0)
            return 1;
        int[] nums=new int[n+1];
        nums[1]=1;
        int max=0;
        for (int i = 1; i <=n ; i++) {
            int index=i*2;
            if(index<=n)
                nums[index]=nums[i];
            if(index+1<=n)
                nums[index+1]=nums[i] + nums[i+1];
            max=Math.max(max,nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        new GetMaximuminGeneratedArray().getMaximumGenerated(7);
    }
}
