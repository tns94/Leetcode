package january21;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3617/
 */
public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
       int start=0,end=1000000,ans=1000000;
       while (start<=end)
       {
            int mid= start + (end - start)/2;
            int[][] v=new int[100][100];
            if(route(heights,0,0,mid, v))
            {
                ans=Math.min(ans,mid);
                end = mid-1;
            }
            else start=mid+1;
       }
       return ans;
    }
    boolean route(int[][] heights,int x,int y,int k,int[][] v)
    {
        if(x==heights.length-1 && y == heights[0].length-1)
            return true;

        int val=heights[x][y];
        v[x][y]=1;
        boolean ans=false;

            if(x>0 && v[x-1][y]==0 && Math.abs(heights[x][y]-heights[x-1][y]) <= k)
                ans = ans||route(heights,x-1,y,k,v);
            if(y>0 &&  v[x][y-1]==0  && Math.abs(heights[x][y]-heights[x][y-1]) <= k)
                ans = ans||route(heights,x,y-1,k,v);
            if(x<heights.length-1 &&  v[x+1][y]==0 && Math.abs(heights[x][y]-heights[x+1][y]) <= k)
                ans = ans||route(heights,x+1,y,k,v);
            if(y<heights[0].length-1 &&  v[x][y+1]==0  && Math.abs(heights[x][y]-heights[x][y+1]) <= k)
                ans = ans||route(heights,x,y+1,k,v);
        return ans;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort p=new PathWithMinimumEffort();
        int[][] h={{1,2,3},{3,8,4},{5,3,5}};
        System.out.println(p.minimumEffortPath(h));
    }
}

/* public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int [][] cost = new int[m][n];
        boolean visited [][] = new boolean[m][n];

        for(int [] c : cost){
            Arrays.fill(c, Integer.MAX_VALUE);
        }

        int xDirs [] = new int[]{-1,1,0,0};
        int yDirs [] = new int[]{0,0,-1,1};

        PriorityQueue<int [] > pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int []{0,0,0});
        visited[0][0] = true;
        int maxSoFar = 0;

        while(!pq.isEmpty()){
            int [] cur = pq.poll();

            visited[cur[0]][cur[1]] = true;

            if(cur[0] == m-1 && cur[1] == n-1)
                return cur[2];

            for(int k = 0; k < 4; k++){
                int x = cur[0] + xDirs[k];
                int y = cur[1] + yDirs[k];
                int currCos = cur[2];

                if(x >= 0 && x < m && y >=0 && y < n && !visited[x][y]){
                    int diff = Math.abs(heights[cur[0]][cur[1]] - heights[x][y]);
                    int maxDiff = Math.max(diff,currCos);

                    if(maxDiff < cost[x][y]){
                        cost[x][y] = maxDiff;
                        pq.offer(new int[]{x,y,cost[x][y]});
                    }
                }
            }
        }
        return cost[m-1][n-1];
    }*/