package december;

import java.util.ArrayDeque;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3580/
 */
public class DiagonalTraverse {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    boolean isValidIndex(int x, int y,boolean[][] visited,int m, int n)
    {
        if(x >= m || y >= n || visited[x][y])
            return false;
        return true;
    }
    public int[] findDiagonalOrder(int[][] matrix) {

        if(matrix == null || matrix.length==0 || matrix[0]==null || matrix[0].length == 0)
            return new int[0];
        int m=matrix.length;
        int n=matrix[0].length;
        int[] ret=new int[m*n];
        int i=0;
        boolean toggle=true;
        boolean[][] visited=new boolean[m][n];
        Queue<Point> queue=new ArrayDeque<>();
        queue.add(new Point(0,0));
        while (!queue.isEmpty())
        {
            int size=queue.size();
            int t=size;
            while (size-- > 0) {
                Point point = queue.poll();
                if(isValidIndex(point.x, point.y+1, visited,m,n)) {
                    visited[point.x][point.y+1]=true;
                    queue.offer(new Point(point.x,point.y+1));
                }
                if(isValidIndex(point.x+1, point.y, visited,m,n)) {
                    visited[point.x+1][point.y]=true;
                    queue.offer(new Point(point.x+1,point.y));
                }
                if(toggle)
                    ret[i+size]=matrix[point.x][point.y];
                else
                    ret[i++]=matrix[point.x][point.y];
            }
            if(toggle)
                i+=t;
            toggle=!toggle;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        new  DiagonalTraverse().findDiagonalOrder(matrix);
    }
}
