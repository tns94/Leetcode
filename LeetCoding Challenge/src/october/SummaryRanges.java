package october;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3510/
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res =new ArrayList<>();
        if(nums == null || nums.length==0)
        {
            return res;
        }
        int start=nums[0];
        int end=start;
        for (int i = 1; i < nums.length; i++) {
            if(end+1 == nums[i])
                end=nums[i];
            else{
                res.add(getRange(start,end));
                start=nums[i];
                end=nums[i];
            }
        }
        res.add(getRange(start,end));
        return res;
    }
    String getRange(int start , int end){
        StringBuilder str=new StringBuilder();
        if(start!=end)
            str.append(start).append("->").append(end);
        else
            str.append(start);
        return str.toString();
    }
}
