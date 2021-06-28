package april21;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3719/
 */
public class CriticalConnectionsinaNetwork {
    List<List<Integer>> criticalEdges;
    List<Integer>[] adjList;
    boolean[] visited;
    int[] lowTime;
    int[] visitedTime;
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        criticalEdges = new ArrayList<>();
        adjList=new List[n];
        visited = new boolean[n];
        lowTime =  new int[n];
        visitedTime = new int[n];
        for(List<Integer> edge:connections)
        {
            int v1=edge.get(0);
            int v2=edge.get(1);

            if(adjList[v1] == null)
                adjList[v1]=new ArrayList<>();
            if(adjList[v2] == null)
                adjList[v2]=new ArrayList<>();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        dfs(0,0);
        return criticalEdges;
    }

    void dfs(int at,int parent)
    {
        visited[at] = true;
        visitedTime[at] = lowTime[at] =time++;
        if(adjList[at] != null){
            for(int adjNode:adjList[at]){
                if(parent == adjNode)
                    continue;
                if(visited[adjNode])
                {
                    lowTime[at] = Math.min(lowTime[at],visitedTime[adjNode]);
                }
                else{
                    dfs(adjNode,at);
                    lowTime[at] = Math.min(lowTime[at],lowTime[adjNode]);
                    if(visitedTime[at] < lowTime[adjNode])
                        criticalEdges.add(Arrays.asList(at,adjNode));
                }
            }
        }
    }

}
