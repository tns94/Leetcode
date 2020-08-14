package july;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3387/
 */
public class Subsets {
    //Generating all subset using bit-manipulation
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets=new ArrayList<>();
        if(nums==null || nums.length==0)
            return subsets;
        int length=nums.length;
        int subsetLength=1<<nums.length;
        for (int i = 0; i < subsetLength; i++) {
            List<Integer> subset=new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if((i & (1<<j)) > 0)
                    subset.add(nums[j]);
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
