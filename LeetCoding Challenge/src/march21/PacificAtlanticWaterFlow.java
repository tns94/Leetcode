package march21;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3684/
 */
public class PacificAtlanticWaterFlow {
    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
    boolean isValid(int x,int y,int m,int n) {
        if (x >= 0 && x < m && y >= 0 && y < n)
            return true;
        return false;
    }
    void dfs(int[][] matrix, boolean[][] reachable, int x, int y, int m , int n){

        reachable[x][y]=true;

        for(int[] dir:dirs){
            int newX=x+dir[0];
            int newY=y+dir[1];
            if(isValid(newX,newY,m,n) && !reachable[newX][newY] && (matrix[x][y] <= matrix[newX][newY]))
            {
                dfs(matrix,reachable,newX,newY,m,n);
            }
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans =new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int m=matrix.length;
        int n=matrix[0].length;

        boolean[][] canTouchAtlantic=new boolean[m][n];
        boolean[][] canTouchPacific=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix,canTouchPacific,i,0,m,n);
            dfs(matrix,canTouchAtlantic,i,n-1,m,n);
        }

        for (int i = 0; i < n; i++) {
            dfs(matrix,canTouchPacific,0,i,m,n);
            dfs(matrix,canTouchAtlantic,m-1,i,m,n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(canTouchAtlantic[i][j] && canTouchPacific[i][j])
                {
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
