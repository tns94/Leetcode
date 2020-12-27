package december;
/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3571/
 */
public class CherryPickupII {
    //Tabulation
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int dp1[][]=new int[cols][cols];
        int dp2[][]=new int[cols][cols];


        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
               int result=grid[rows-1][i];
                if(i!=j)result+=grid[rows-1][j];
                dp1[i][j]=result;
            }
        }

        for (int i = rows-2; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {

                    int result=grid[i][j];
                    if(j!=k) result += grid[i][k];
                    int[] dirs={-1,0,1};
                    int ans=0;
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            int j1c=j+dirs[l];
                            int j2c=k+dirs[m];
                            if(j1c >=0 && j1c < cols && j2c >=0 && j2c < cols )
                            ans=Math.max(ans,dp1[j1c][j2c]);
                        }
                    }
                    dp2[j][k]=ans+result;

                }
            }
            dp1=dp2;
            dp2=new int[cols][cols];
        }
        return dp1[0][cols-1];
    }

    //TOP-DOWN DP
    /*    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Integer dp[][][]=new Integer[71][71][71];
        return cherryDP(grid,0,0,cols-1,dp);
    }
    int cherryDP(int[][] grid, int row, int j1,int j2,Integer dp[][][])
    {
        int rows=grid.length;
        int cols=grid[0].length;
        if(row == rows)
            return 0;
        if(dp[row][j1][j2]!=null)
            return dp[row][j1][j2];

        int sum=grid[row][j1];
        if(j1!=j2) sum+=grid[row][j2];
        int[] dirs={-1,0,1};
        int ans=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int j1c=j1+dirs[i];
                int j2c=j2+dirs[j];
                if(j1c >=0 && j1c < cols && j2c >=0 && j2c < cols )
                    ans = Math.max(ans,cherryDP(grid,row+1,j1c,j2c,dp));
            }
        }
        return dp[row][j1][j2]=ans+sum;
    }*/
}
