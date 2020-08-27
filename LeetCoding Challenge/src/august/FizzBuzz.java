package august;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3437/
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i%5==0 && i%3==0)
                list.add("FizzBuzz");
            else if(i%3==0)
                list.add("Fizz");
            else if(i%5==0)
                list.add("Buzz");
            else list.add(String.valueOf(i));
        }
        return list;
    }
}
