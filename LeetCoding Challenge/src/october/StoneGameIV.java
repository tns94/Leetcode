package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3507/
 */
public class StoneGameIV {
    public boolean winnerSquareGame(int n) {
        boolean[] isWin = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (!isWin[i - k * k]) {
                    isWin[i] = true;
                    break;
                }
            }
        }
        return isWin[n];
    }
}
