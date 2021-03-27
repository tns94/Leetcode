package february21;

import java.util.ArrayDeque;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3638/
 */
public class ShortestPathinBinaryMatrix {
    class Pair {
        int x, y, dis;

        public Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    boolean valid(int x, int y, int m, int n) {

        if (x < 0 || x >= m || y < 0 || y >= n)
            return false;
        return true;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] diff = {{0, -1}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(0, 0, 1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.x == m - 1 && pair.y == n - 1)
                return pair.dis;
            for (int[] i : diff) {
                int newX = pair.x + i[0];
                int newY = pair.y + i[1];
                if (valid(newX, newY, m, n) && grid[newX][newY] == 0) {

                    grid[newX][newY] = 1;
                    queue.offer(new Pair(newX, newY, pair.dis + 1));
                }
            }
        }
        return -1;
    }
}
