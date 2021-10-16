package april21;
/*
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3721/
 */
import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> brickAllocations = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb <= 0) {
                continue;
            }
            brickAllocations.add(climb);
            bricks -= climb;
            if (bricks < 0 && ladders == 0) {
                return i;
            }
            if (bricks < 0) {
                bricks += brickAllocations.remove();
                ladders--;
            }
        }
        return heights.length - 1;
    }
}
