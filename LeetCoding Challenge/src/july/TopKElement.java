package july;

import java.util.*;

public class TopKElement {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map=new TreeMap<>();
        for (int i:nums)
        {
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue
                = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result =new int[queue.size()];
        int i=0;
        while (queue.size() > 0) {
            result[i++]=queue.poll().getKey();
        }
    return result;
    }
}
