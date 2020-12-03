package november;

import java.util.ArrayDeque;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/568/week-5-november-29th-november-30th/3548/
 */
public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> indexQueue=new ArrayDeque<>();
        indexQueue.offer(start);
        while (!indexQueue.isEmpty())
        {
            int index=indexQueue.poll();
            if(arr[index]==0)
                return true;
            int leftIndex=index-arr[index];
            int rightIndex=index+arr[index];
            arr[index]=-1;
            if(leftIndex>=0 && arr[leftIndex]!=-1) {
                indexQueue.offer(leftIndex);
            }
            if(rightIndex<arr.length && arr[rightIndex]!=-1) {
                indexQueue.offer(rightIndex);
            }
        }
        return false;
    }
}
