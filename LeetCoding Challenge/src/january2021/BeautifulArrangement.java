package january2021;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3591/
 */
public class BeautifulArrangement {
    public int countArrangement(int n) {
        int mask=0;
        return count(mask, 1,n);
    }
    int count(int mask,int index,int n)
    {
        if(index==n+1){
            return 1;
        }
        int co=0;
        for (int i = 1; i <= n; i++) {
            if(!((mask & 1<<i)>0) && (index%i==0 || i%index==0 )){
                mask = mask | (1<<i);
                co+=count(mask,index+1,n);
                mask = mask & ~(1<<i);
            }
        }
        return co;
    }
}
