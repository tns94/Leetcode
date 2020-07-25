package july;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3400/
 */
public class All_Paths_From_Source_to_Target {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path=new ArrayList<>();
        dfs(graph,0,path);
        return list;
    }
    void dfs(int[][] graph,int vertex,List<Integer> path)
    {
        if(vertex==graph.length-1)
        {
            List<Integer> tempList=new ArrayList<>(path);
            tempList.add(graph.length-1);
            list.add(tempList);
            return;
        }
        path.add(vertex);
        for (int i = 0; i < graph[vertex].length; i++) {
                dfs(graph,graph[vertex][i],path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        new All_Paths_From_Source_to_Target().allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
    }
}
