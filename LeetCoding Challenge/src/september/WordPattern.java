package september;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3451/
 */
public class WordPattern {
   public boolean wordPattern(String pattern, String str) {
        String[] arr=new String[26];
        String[] tokens=str.split("\\s");
        Set<String> set=new HashSet<>();
        if(pattern.length()!= tokens.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            int index=pattern.charAt(i)-97;
            if(arr[index]==null)
            {
                if(set.contains(tokens[i]))
                    return false;
                arr[index]=tokens[i];
                set.add(tokens[i]);
            }
            else if(!arr[index].equals(tokens[i]))
                return false;
        }
        return true;
    }
}
