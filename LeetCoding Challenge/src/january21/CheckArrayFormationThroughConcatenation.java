package january21;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3589/
 */
public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Integer[] ar = new Integer[101];
        for (int i = 0; i < arr.length; i++) {
            ar[arr[i]] = i;
        }
        for (int i = 0; i < pieces.length; i++) {
            if (ar[pieces[i][0]] == null)
                return false;
            for (int j = 1; j < pieces[i].length; j++) {
                if (ar[pieces[i][j]] == null || ar[pieces[i][j]] - ar[pieces[i][j - 1]] != 1)
                    return false;
            }
        }
        return true;
    }
}
