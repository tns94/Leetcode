package february21;
/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3637/
 */
public class NumberofStepstoReduceaNumbertoZero {
    public int numberOfSteps (int num) {
        int co=0;
        while (num > 0)
        {
            if((num & 1) ==1)
                num--;
            else num /= 2;
            co++;
        }
        return co;
    }
}
