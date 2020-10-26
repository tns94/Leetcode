package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3506/
 */
public class BagofTokens {
    public static int bagOfTokensScore(int[] tokens, int P) {
        return maxScore(tokens,new boolean[tokens.length],tokens.length,0,P);
    }
    static int maxScore(int[] tokens,boolean[] isTokenUsed,int tokenUsedCount,int score, int power)
    {
        if(tokenUsedCount==0)
            return 0;
        int max=0;
        for (int i = 0; i < tokens.length; i++) {
            if(!isTokenUsed[i])
            {
                isTokenUsed[i]=true;
                if(power>=tokens[i])
                    max=Math.max(max,maxScore(tokens,isTokenUsed,tokenUsedCount-1,score+1,power-tokens[i])+1);
                if(score>=1)
                    max=Math.max(max,maxScore(tokens,isTokenUsed,tokenUsedCount-1,score-1,power+tokens[i])-1);
                isTokenUsed[i]=false;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{26},51));
    }
}
