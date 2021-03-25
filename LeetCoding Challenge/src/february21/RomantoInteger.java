package february21;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3646/
 */
public class RomantoInteger {

    public int romanToInt(String s) {
        Map<String,Integer> map=new HashMap<>();
        map.put("IV",4);
        map.put("IX",9);
        map.put("XC",90);
        map.put("XL",40);
        map.put("CD",400);
        map.put("CM",900);
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        int ans=0;
        char[] arr=s.toCharArray();
        for (int i = arr.length-1; i >= 0; i--) {
            String str=String.valueOf(arr[i]);
            if(i>0 && map.containsKey(arr[i-1]+str)){
                ans+= map.get(arr[i-1]+str);
                i--;
            }else
                ans += map.get(str);

        }
        return ans;
    }

}
