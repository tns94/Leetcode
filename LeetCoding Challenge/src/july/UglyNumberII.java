package july;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
     List<Integer> sieve;
    UglyNumberII()
    {
        sieve=new ArrayList<>();
        int max=33493;
        int sqrt=184;

        boolean[] arr=new boolean[max];
        arr[1]=true;

        for (int j = 2; j < max; j+=2)
            arr[j]  =true;
        for (int j = 3; j < max; j+=3)
            arr[j]  =true;
        for (int j = 5; j < max; j+=5)
            arr[j]  =true;

        for (int i = 7; i < max; i++) {
            if(!arr[i])
            for (int j = i; j < sqrt; j+=i)
                arr[j]  = false;
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i])
                sieve.add(i);
        }
    }
    public int nthUglyNumber(int n) {
        return sieve.get(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(1609));
    }
}
