package august;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3414/
 */
public class Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> answer=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num=Math.abs(nums[i])-1;
            if(nums[num]<0)
                answer.add(num+1);
            nums[num]=-nums[num];
        }
        return answer;
    }

    public static void main(String[] args) {
        new Find_All_Duplicates_in_an_Array().findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
}
