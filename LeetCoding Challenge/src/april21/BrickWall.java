package april21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3717/
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map=new HashMap<>();
        int len=wall.size();
        int max=0;
        for (int i = 0; i < len; i++) {
            int sum=0;
            List<Integer> innerList = wall.get(i);
            for (int j = 0; j < innerList.size()-1; j++)
            {
                sum+= innerList.get(j);
                int currentCount=map.getOrDefault(sum,0)+1;
                map.put(sum,currentCount);
                max = Math.max(max,currentCount);
            }

        }
        return len-max;
    }
}
