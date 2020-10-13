package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3466/
 */
public class UniquePathsIII {
    int[][] paths={{-1,0},{1,0},{0,-1},{0,1}};
    int traverse(int[][] grid,int x,int y,int zeroCount,int pathCount)
    {
        if(grid[x][y]==2)
        {
            if(zeroCount==pathCount)
                return 1;
            else
                return 0;
        }

        int count = 0;
        grid[x][y]=-1;
        for (int i = 0; i < 4; i++) {
            int tempX=x+paths[i][0];
            int tempY=y+paths[i][1];
            if(((tempX>=0 && tempX<grid.length) && (tempY>=0 && tempY<grid[0].length)) && grid[tempX][tempY]!=-1)
                 count += traverse(grid,tempX,tempY,zeroCount+1,pathCount);
        }
        grid[x][y]=0;
        return count;
    }
    public int uniquePathsIII(int[][] grid) {
        int pathCount=0;
        int x=0,y=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==0)
                    pathCount++;
                if(grid[i][j]==1)
                {
                    x=i;
                    y=j;
                }
            }
        }
        grid[x][y]=-1;
        return traverse(grid,x,y,0,++pathCount);
    }

    public static void main(String[] args) {
        UniquePathsIII uniquePathsIII=new UniquePathsIII();
       System.out.println(uniquePathsIII.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }
}
