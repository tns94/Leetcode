package september;
/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3455/
 */
public class BullsandCows {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        int[] countSecret=new int[10];
        int[] countGuess=new int[10];


        for (int i = 0; i < secret.length(); i++) {
            char se=secret.charAt(i);
            char gu=guess.charAt(i);

            if(se==gu)
                bulls++;
            else
            {
                countSecret[se-'0']++;
                countGuess[gu-'0']++;
            }
        }
        for (int i = 0; i < 10; i++)
            cows+=Math.min(countGuess[i],countSecret[i]);

        return bulls+"A"+cows+"B";
    }
}
