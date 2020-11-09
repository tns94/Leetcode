package october;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3520/
 */
public class MinimumCosttoMoveChipstoTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int even=0,odd=0;
        for(int chip:position)
        {
            if((chip&1)==1) odd++;
            else even++;
        }
        return Math.min(odd,even);
    }
}
