package september;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3465/
 */
public class SequentialDigits {

    static void generateSequentialDigits(List<Integer> integerList,int num,int low,int high,int current)
    {
        if(num<=high && num>=low)
            integerList.add(num);
        if(num>high || current==9)
            return;
        generateSequentialDigits(integerList,(num*10)+current+1,low,high,current+1);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();
        if(low>high)
            return list;
        int lo=0;
        while(lo < 10)
        generateSequentialDigits(list,0,low,high,lo++);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        SequentialDigits sequentialDigits=new SequentialDigits();
        List<Integer> list=sequentialDigits.sequentialDigits(58,155);

        list.forEach(System.out::println);
    }
}
