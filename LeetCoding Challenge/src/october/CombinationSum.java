package october;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3481/
 */

public class CombinationSum {

    List<List<Integer>> list=new ArrayList<>();
    void generateCombinations(int[] candidates, int target,List<Integer> currentList, int currentSum,int currentIndex)
    {
        if(currentSum == target)
        {
            list.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = currentIndex; i < candidates.length; i++) {
            int num=candidates[i];
            if(currentSum + num <= target) {
                currentList.add(num);
                generateCombinations(candidates, target, currentList, currentSum + num, i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        generateCombinations(candidates,target,new ArrayList<>(),0,0);
        return list;
    }
}
