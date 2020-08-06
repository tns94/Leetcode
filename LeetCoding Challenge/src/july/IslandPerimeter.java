package july;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/
 */
public class IslandPerimeter {
    int[][] cor={{-1,0},{1,0},{0,-1},{0,1}};
    boolean isValid(int x,int y,int[][] grid)
    {
        if((x>=0 && x<grid.length) && (y>=0 && y<grid[0].length))
            return true;
        return false;
    }

    int DFS(int[][] grid,int x,int y)
    {
        int co=0;
        grid[x][y]=-1;
        for (int i = 0; i < 4; i++) {
            int p=x+cor[i][0];
            int q=y+cor[i][1];
            if(isValid(p,q,grid)) {
                if(grid[p][q]==1)
                {
                    co+=DFS(grid, p, q);
                }
                else if(grid[p][q]==0)
                    co++;
            }
            else
                co++;
        }
        return co;
    }
    public int islandPerimeter(int[][] grid) {
         if(grid==null)
            return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1)
                    return DFS(grid,i,j);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // int re=new IslandPerimeter().islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}});
        int re=new IslandPerimeter().islandPerimeter(new int[][]{{1,1},{1,1}});
        System.out.println(re);
    }
}
