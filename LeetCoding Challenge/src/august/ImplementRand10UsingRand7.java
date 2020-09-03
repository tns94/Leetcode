package august;
/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3439/
 */
public class ImplementRand10UsingRand7 {
    public int rand7(){
        return ((int)Math.random()%7)+1;
    }
    public int rand10() {
        int rand10=49;
        while(rand10>=40)
            rand10 = 7*(rand7()-1) + (rand7()-1);

        return rand10 % 10 + 1;
     }
}
