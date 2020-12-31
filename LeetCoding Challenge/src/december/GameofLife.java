package december;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3586/
 */
public class GameofLife {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{-1,-1},{1,-1}};
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int live = 0;
                for(int[] dir : dirs){
                    int p = dir[0] + i;
                    int q = dir[1] + j;
                    if(p < 0 || q < 0 || p >= m || q >= n) continue;
                    if(board[p][q] == 1 || board[p][q] == 2) live++;
                }
                if(board[i][j] == 0 && live == 3) board[i][j] = 3;
                if(board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2;
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < n; j++){
                board[i][j] %= 2;
            }
        }
    }
}
