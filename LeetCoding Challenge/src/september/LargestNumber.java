package september;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3472/
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        StringBuilder largestNum=new StringBuilder();
        String[] arr=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(o1, o2) ->{
            return (o2+o1).compareTo(o1+o2);
        });
        if(arr[0].equals("0"))
            return "0";
        for(String s:arr)
            largestNum.append(s);

        return largestNum.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber=new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{999999998,999999997,999999999}));
    }
}
