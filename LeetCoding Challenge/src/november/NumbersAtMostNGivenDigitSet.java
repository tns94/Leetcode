package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3538/
 */
public class NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int [] map =new int[10];
        boolean [] isPresent = new boolean[10];
        for(String s : digits){
            int d = Integer.parseInt(s);
            for(int i =d+1;i<10;i++)
                map[i]++;
            isPresent[d] = true;
        }
        return atMostNGivenDigitSet(n, map, isPresent, digits.length);
    }
    private int atMostNGivenDigitSet(int n, int []map, boolean [] isPresent,int length){
        //print(map, isPresent);
        String number = Integer.toString(n);
        int k = number.length();
        int result = 0;
        int pow = 1;
        for(int i =1; i<k; i++){
            pow *= length;
            result += pow;
        }
        while(k > 0){
            int digit= number.charAt(number.length()-k) - '0';
            result += (map[digit]*permutiation(length, k-1));
            if(!isPresent[digit])
                return result;
            k--;
        }
        result++;
        return result;
    }

    private int permutiation(int n, int k){
        int result = 1;
        for(int i =0; i<k; i++)
            result *= n;
        return result;
    }
}
