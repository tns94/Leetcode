package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3500/
 */
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        if(A[0] == B[0])
            return countMin(A,B,A[0]);
        int countA=countMin(A,B,A[0]);
        if(countA>0)
            return countA;
        return countMin(A,B,B[0]);
    }

    int countMin(int[] A, int[] B,int num)
    {
        int flipCountA=0;
        int flipCountB=0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]!=num && B[i]!=num)
                return -1;
            if(A[i] != num)
                flipCountA++;
            else if(B[i] != num)
                flipCountB++;
        }
        return Math.min(flipCountA,flipCountB);
    }
}

