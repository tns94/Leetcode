package july;

/*
https://leetcode.com/submissions/detail/362958836/?from=/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3382/
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean isLastDigitNine=true;
        for (int i = digits.length-1; i >= 0; i--) {
            if(digits[i]<9)
            {
                digits[i]=digits[i]+1;
                isLastDigitNine=false;
                break;
            }
            else
            {
                digits[i]=0;
            }
        }
        if(isLastDigitNine)
        {
            int[] answer=new int[digits.length+1];
            for (int i = 1; i <= digits.length; i++) {
                answer[i]=digits[i-1];
            }
            answer[0]=1;
            return answer;
        }
        return digits;
    }
}
