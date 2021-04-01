package march21;


/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3682/
 */
public class _3SumWithMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
        long counter[]=new long[101];
        for(int a:arr)
            counter[a]++;
        long ans=0;
        for(int i=0;i<=100;i++){
            for(int j=i;j<=100;j++){
                int k=target-i-j;
                if(k>100||k<0)
                    continue;
                if(i==j&&j==k)
                    ans+=counter[i]*(counter[i]-1)*(counter[i]-2)/6;
                else if(i==j&&j!=k)
                    ans+=counter[i]*(counter[i]-1)/2*counter[k];
                else if(j<k)
                    ans+=counter[i]*counter[j]*counter[k];

                ans %= 1000000007;
            }
        }
        return (int)ans;
    }
}
