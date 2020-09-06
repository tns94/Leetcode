package august;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/
 */
public class NumbersWithSameConsecutiveDifferences {

    static void generate(List<Integer> list,int num,int i,int N,int K,int index){
        if(index==N)
        {
           list.add(num);
           return;
        }
        int minus=i-K;
        int plus=i+K;
        if(minus>=0)
        {
            generate(list,num*10+minus,minus,N,K,index+1);
        }
        if(K>0 && plus<=9)
        {
            generate(list,num*10+plus,plus,N,K,index+1);
        }
    }
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            generate(list,i,i,N,K,1);
        }
        if(N==1)
            list.add(0);
        int size=list.size();


        int[] answer=new int[size];
        for (int i = 0; i < size; i++) {
            answer[i]=list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr=new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(1,0);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
