package july;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3388/
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int size=31;
        int answer=0;
        while (size >= 0)
        {
            if(((1 << size) & n) != 0)
                answer = answer | (1<<31-size);
            size--;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits( -3));
    }
}
