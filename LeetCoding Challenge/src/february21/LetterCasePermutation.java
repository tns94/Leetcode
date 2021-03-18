package february21;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3642/
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> list=new ArrayList<>();
        dp(S,new StringBuilder(),0,list);
        return list;
    }
    void dp(String s,StringBuilder str,int index,List<String> list)
    {
        if(index==s.length())
        {
            list.add(str.toString());
            return;
        }
        char ch=s.charAt(index);
        str.append(ch);
        dp(s,str,index+1,list);
        str.deleteCharAt(index);
        if(Character.isLetter(ch))
        {
            if(Character.isLowerCase(ch))
                ch=Character.toUpperCase(ch);
            else
                ch=Character.toLowerCase(ch);
            str.append(ch);
            dp(s,str,index+1,list);
            str.deleteCharAt(index);
        }
    }
}
