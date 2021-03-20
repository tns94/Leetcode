package february21;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3628/
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int currKey = entry.getKey();
            int freq =entry.getValue();
            int currLHS = 0;
            if(map.containsKey(currKey+1)){ // 1 1 1 1
                currLHS = freq + map.get(currKey+1);
            }
            max = Math.max(max, currLHS);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence l=new LongestHarmoniousSubsequence();
        System.out.println(l.findLHS(new int[]{1,3,2,2,5,2,3,7}));

    }
}
