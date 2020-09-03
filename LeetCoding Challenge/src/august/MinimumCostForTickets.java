package august;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3436/
 */
public class MinimumCostForTickets {

    public int solve(int[] days,int costs[], int index,int daysCovered,int[][] dp)
    {
        if(index==days.length || daysCovered>365)
            return 0;
        if(dp[index][daysCovered]!=0)
            return dp[index][daysCovered];
        
        int min=Integer.MAX_VALUE;

        if(days[index]>daysCovered){
            min=Math.min(costs[0]+solve(days,costs,index+1,daysCovered,dp),costs[1]+solve(days,costs,index+1,days[index]+6,dp));
            return dp[index][daysCovered]=Math.min(min,costs[2]+solve(days,costs,index+1,days[index]+29,dp));
        }
        else return dp[index][daysCovered]=solve(days,costs,index+1,daysCovered,dp);

    }

    public int mincostTickets(int[] days, int[] costs) {
        int[][] dp=new int[days.length][366];

        int answer= solve(days,costs,0,0,dp);
        for (int i = 0; i < days.length; i++) {
            for (int j = 0; j < 366; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        new MinimumCostForTickets().mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,15});
    }
}
