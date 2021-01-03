package december;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3582/
 */
public class JumpGameIV {
    int bfs(Map<Integer,List<Integer>> map,int[] arr)
    {
        int n=arr.length;
        int co=0;
        boolean[] visited=new boolean[n+1];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty())
        {
            int size=queue.size();

            while(size-->0) {
                int index = queue.poll();
                if(index==n-1)
                    return co;

                if(index < 0 || index>=arr.length || visited[index]){
                    continue;
                }
                if(index > 0 && !visited[index-1])
                    queue.offer(index-1);
                if(index < n-1 && !visited[index+1])
                    queue.offer(index+1);

                if(map.containsKey(arr[index]))
                {
                    for(int i:map.get(arr[index])){
                        if(!visited[i])
                            queue.offer(i);
                    }
                    map.remove(arr[index]);
                }
                visited[index] = true;
            }
            co++;
        }
        return 0;
    }
    public int minJumps(int[] arr) {
        Map<Integer,List<Integer>> map=new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }
    return bfs(map,arr);
    }

    public static void main(String[] args) {
        JumpGameIV jumpGameIV=new JumpGameIV();
        int[] arr={7};
        System.out.println(jumpGameIV.minJumps(arr));
    }
}
