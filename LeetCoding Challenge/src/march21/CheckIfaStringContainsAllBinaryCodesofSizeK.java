package march21;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3669/
 */
public class CheckIfaStringContainsAllBinaryCodesofSizeK {
    public boolean hasAllCodes(String s, int k) {
        int need = 1<<k;
        int hash = 0;
        int allONe= need-1;
        boolean[] got = new boolean[need];
        for (int i = 0; i < s.length(); i++) {
            hash = (hash<<1 & allONe) | (s.charAt(i) - '0');
            if(i >= k-1 && !got[hash])
            {
                need--;
                got[hash]=true;
                if(need == 0)
                    return true;
            }
        }
        return false;
    }
}
