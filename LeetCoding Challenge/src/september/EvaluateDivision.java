package september;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    static double DFS(double[][] matrix,int v,int current,int end,boolean[] visited,double answer)
    {
        if(current==end)
            return answer;

        visited[current]=true;
        for (int i = 0; i < v; i++) {
            if(matrix[current][i]!=0 && !visited[i])
            {
                double ans=DFS(matrix,v,i,end,visited,answer * matrix[current][i]);
                if(ans!=-1)
                    return ans;
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answer=new double[queries.size()];
        double[][] adjacencyMatrix=new double[40][40];
        Map<String,Integer> indexMap=new HashMap<>();
        int nodeNum=0;
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation= equations.get(i);
            String node1=equation.get(0);
            String node2=equation.get(1);
            int node1Index,node2Index;

            if(indexMap.containsKey(node1))
                node1Index=indexMap.get(node1);
            else
            {
                node1Index=nodeNum++;
                indexMap.put(node1,node1Index);
            }

            if(indexMap.containsKey(node2))
                node2Index=indexMap.get(node2);
            else
            {
                node2Index=nodeNum++;
                indexMap.put(node2,node2Index);
            }
            adjacencyMatrix[node1Index][node2Index]=values[i];
            adjacencyMatrix[node2Index][node1Index]=1/values[i];
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query= queries.get(i);
            String node1=query.get(0);
            String node2=query.get(1);
            if(indexMap.containsKey(node1) &&  indexMap.containsKey(node2))
                answer[i]=DFS(adjacencyMatrix,40,indexMap.get(node1),indexMap.get(node2),new boolean[40],1);
            else
                answer[i]=-1;

        }
        return answer;
    }

}
