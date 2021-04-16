package march21;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3677/
 */
public class KeysandRooms {
    void bfs(List<List<Integer>> rooms,boolean[] visited)
    {
        Queue<Integer> queue=new ArrayDeque<>();
        visited[0]=true;
        for(int keys:rooms.get(0))
            queue.offer(keys);
        while (!queue.isEmpty())
        {
            int room=queue.poll();
            visited[room]=true;
            for(int keyOfroom: rooms.get(room))
            {
                if (!visited[keyOfroom])
                queue.offer(keyOfroom);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isAllRoomsOpen = new boolean[rooms.size()];
        bfs(rooms, isAllRoomsOpen);
        for (boolean isOpen : isAllRoomsOpen)
            if (!isOpen)
                return false;
        return true;
    }
}
