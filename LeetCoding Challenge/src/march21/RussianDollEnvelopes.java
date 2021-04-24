package march21;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/592/week-5-march-29th-march-31st/3690/
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b) ->   a[0] - b[0]);
        int[] ans=new int[envelopes.length];
        Arrays.fill(ans,1);
        int max=0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i+1; j < envelopes.length; j++) {
                if(envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1])
                    ans[j] = Math.max(ans[j],ans[i]+1);
            }
            max=Math.max(max,ans[i]);
        }
        return max;
    }
}
