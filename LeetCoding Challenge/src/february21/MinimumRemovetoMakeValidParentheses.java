package february21;
/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3645/
 */
public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int balance=0;
        char[] arr=s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='(')
                balance++;
            else if(arr[i]==')')
                balance--;
            if(balance<0)
            {
                arr[i]=0;
                balance++;
            }
        }
        balance=0;
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i]==')')
                balance++;
            else if(arr[i]=='(')
                balance--;
            if(balance < 0)
            {
                arr[i]=0;
                balance++;
            }
        }
        StringBuilder str=new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!= 0)
                str.append(arr[i]);
        }
        return str.toString();
    }
}
