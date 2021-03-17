package february21;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3639/
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> red=new HashSet<>();
        Set<Integer> green=new HashSet<>();


        boolean toggle=false;
        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(0);
        red.add(0);
        boolean[] vis=new boolean[graph.length];
        vis[0]=true;
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0) {
                int node = queue.poll();
                for (int i = 0; i < graph[node].length; i++) {
                    int neighbour=graph[node][i];
                    if(!toggle)
                    {
                        if(checkSet(neighbour,red))
                            return false;
                        if(addInSet(neighbour,green))
                        {
                            queue.offer(neighbour);
                            vis[neighbour]=true;
                        }
                    }
                    else {
                        if(checkSet(neighbour,green))
                            return false;
                        if(addInSet(neighbour,red))
                        {
                            queue.offer(neighbour);
                            vis[neighbour]=true;
                        }
                    }
                }
            }
            toggle = !toggle;
            if(queue.isEmpty())
            {
                for (int i = 0; i < vis.length; i++) {
                    if (!vis[i])
                    {
                        vis[i]=true;
                        queue.offer(i);
                        break;
                    }
                }
            }
        }
        return true;
    }
    boolean checkSet(int i,Set<Integer> A){
        return A.contains(i);
    }
    boolean addInSet(int i,Set<Integer> A)
    {
        if(!A.contains(i))
        {
            A.add(i);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graph={{1},{0},{4},{4},{2,3}};
        IsGraphBipartite g=new IsGraphBipartite();
        //System.out.println(g.isBipartite(graph));
        System.out.println(g.isBipartite2(graph));
    }
    public boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for(int i=0;i<n;i++) {
            if(colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if(colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for(int next: graph[node]) {
            if(!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}
