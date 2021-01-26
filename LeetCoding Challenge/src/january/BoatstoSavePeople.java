package january;

import java.util.Arrays;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3602/
 */
public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int boats=0;
        Arrays.sort(people);
        int i=0,j=people.length-1;
        while (i<=j)
        {
            if(people[i]+people[j] <= limit)
                i++;
            j--;
            boats++;
        }
        return boats;
    }
}
