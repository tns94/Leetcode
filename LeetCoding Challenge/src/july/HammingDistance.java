package july;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/
 */
public class HammingDistance {

    //XOR x,y will result in number 1's is equal to hamming distance
    //count no. of 1's in ans
    public int hammingDistance(int x, int y) {
        int ans=x^y;
        int count=0;
        while(ans!=0)
        {
            if((ans&1)==1)count++;
            ans=ans>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1,4));
    }
}
