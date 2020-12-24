package december;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3569/
 */
public class _4SumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int count=0;
        int len=A.length;
        Map<Integer,Integer> dp=new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum=A[i]+B[j];
                dp.put(sum,dp.getOrDefault(sum,0)+1);
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum=C[i]+D[j];
                count += dp.getOrDefault(-sum,0);
            }
        }
        return count;

    }



/*DP
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int[][] allFour=new int[4][A.length];
        allFour[0]=A;
        allFour[1]=B;
        allFour[2]=C;
        allFour[3]=D;
        Map<String,Integer> dp=new HashMap<>();
        return totalcount(allFour,0,0,dp);
    }
    int totalcount(int[][] allfour,int arr,int sum, Map<String,Integer> dp)
    {
        if (arr==4 && sum==0)
            return 1;
        if(arr == 4)
            return 0;
        String key=arr+"_"+sum;
        if(dp.containsKey(key))
            return dp.get(key);
        int co=0;
        for (int i = 0; i < allfour[0].length; i++) {
            co+= totalcount(allfour,arr+1,sum+allfour[arr][i],dp);
        }
        dp.put(key,co);
        return co;
    }
    */


}
