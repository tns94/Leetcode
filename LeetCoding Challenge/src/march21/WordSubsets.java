package march21;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3685/
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> answer=new ArrayList<>();
        int[] countB=new int[26];

        for (int i = 0; i < B.length; i++) {
            countChars(countB,B[i].toCharArray());
        }
        for (int i = 0; i < A.length; i++) {
            int[] countA = new int[26];
            countChars(countA, A[i].toCharArray());
            if (isPresent(countA, countB)) {
                answer.add(A[i]);
            }
        }
        return answer;
    }
    boolean isPresent(int[] countA,int[] countB)
    {
        for (int i = 0; i < 26; i++) {
            if(countA[i]<countB[i])
                return false;
        }
        return true;
    }
    void countChars(int[] countB,char[] word)
    {
        int[] counter=new int[26];
        for(char c:word)
            counter[c-97]++;
        for (int i = 0; i < 26; i++) {
            countB[i] = Math.max(countB[i],counter[i]);
        }
    }
}
