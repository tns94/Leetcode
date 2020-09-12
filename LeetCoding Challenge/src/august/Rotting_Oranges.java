package august;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3418/
 */
public class Rotting_Oranges {
    int[][] adjacentPoints={{-1,0},{1,0},{0,-1},{0,1}};
    int maxR, maxC, fresh;
    List<Point> points=new ArrayList<>();
    boolean isValid(int x,int y)
    {
        if(x>=0 && x<maxR && y>=0 && y<maxC)
            return true;
        return false;
    }
    public int orangesRotting(int[][] grid) {

        maxR =grid.length;
        maxC =grid[0].length;

        for (int i = 0; i < maxR; i++) {
            for (int j = 0; j < maxC; j++) {
                if(grid[i][j]==2)
                    points.add(new Point(i,j));
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        int minutes=0;
        while (points.size()!=0)
        {
            if(pass(grid))
                minutes++;
        }
        if(fresh==0)
            return minutes;
        else return -1;
    }
    boolean pass(int[][] grid)
    {
        List<Point> tempPoints=new ArrayList<>();
        for (Point p:points)
            rot(tempPoints,p,grid);

        points=tempPoints;
        if(points.size()>0)
            return true;
        return false;
    }
    void rot(List<Point> tempPoints,Point p,int[][] grid)
    {
        for (int[] ap:adjacentPoints) {
            int x=p.x+ap[0];
            int y=p.y+ap[1];
            if(isValid(x,y) && grid[x][y]==1)
            {
                fresh--;
                grid[x][y]=2;
                tempPoints.add(new Point(x,y));
            }
        }
    }
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Rotting_Oranges().orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
