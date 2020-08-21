package august;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3427/
 */
public class DistributeCandiestoPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans=new int[num_people];
        int round=1;
        loop:
        while(candies>0)
        {
            for (int i = 0; i < num_people; i++) {
                if(candies<round)
                {
                    ans[i] = ans[i] + candies;
                    break loop;
                }
                else
                    ans[i] = ans[i] + round;
                candies-=round;
                round++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new DistributeCandiestoPeople().distributeCandies(7,4);
    }
}
