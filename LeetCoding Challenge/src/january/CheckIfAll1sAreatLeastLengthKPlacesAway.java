package january;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3616/
 */
public class CheckIfAll1sAreatLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int last = -1;
        for(int i=0;i < nums.length;i++){
            if (nums[i] == 1)
            {
                if (last != -1  && i-last - 1 < k)
                    return false;
                last=i;
            }
        }
        return true;
    }
}
