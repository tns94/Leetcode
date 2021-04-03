package march21;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3683/
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] ans=new int[A.length];
        PriorityQueue<int[]> queue=new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        for (int i = 0; i < B.length; i++) {
            queue.offer(new int[]{i,B[i]});
        }

        int i=0,j=A.length-1;
        while (!queue.isEmpty())
        {
            int[] valB=queue.poll();
            int indexB=valB[0];
            int maxB=valB[1];
            if(A[j] > maxB)
            {
                ans[indexB] = A[j--];
            }
            else{
                ans[indexB] = A[i++];
            }
        }
        return ans;
    }
}
