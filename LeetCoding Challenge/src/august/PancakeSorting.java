package august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3441/
 */
public class PancakeSorting {
    static void flipArray(int[] A,int to)
    {
        int i=0,j=to;
        while(i<j)
        {
            int temp=A[i];
            A[i]=A[j];
            A[j]=temp;
            i++;j--;
        }
    }
    static int getIndex(int[] A, int ele)
    {
        for (int i = 0; i < A.length; i++) {
            if(A[i]==ele)
                return i;
        }
        return -1;
    }
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> answer=new ArrayList<>();
        int[] sorted=Arrays.copyOf(A,A.length);
        Arrays.sort(sorted);
        for (int i = A.length-1; i >= 0; i--) {
            int index=getIndex(A,sorted[i]);
            if(index==i)
                continue;
            if(index!=0)
            {
                flipArray(A,index);
                answer.add(index+1);
            }
            flipArray(A,i);
            answer.add(i+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Integer> flips=new PancakeSorting().pancakeSort(new int[]{3,2,4,1});
        flips.forEach(System.out::println);
    }
}
