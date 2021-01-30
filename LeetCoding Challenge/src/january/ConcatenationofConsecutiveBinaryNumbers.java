package january;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3618/
 */
public class ConcatenationofConsecutiveBinaryNumbers {
   /* public int concatenatedBinary(int n) {
        long ans=0;
        long mod=1000000007;
        long pow=1;
        for (int i = n; i > 0; i--) {
            int temp=i;
            int j=0;
            while(temp != 0){
                if((i & 1 << j)>0)
                    ans= (ans+pow)%mod;
                temp = temp & ~(1 << j);
                pow = (pow * 2)%mod;
                j++;
            }
        }
        return (int)ans;
    }*/

    public int concatenatedBinary(int n) {
        long ans=0;
        long mod=1000000007;
        for (int i = 1; i <= n; i++) {
            int temp=i;
            int co=0;
            while (temp > 0){
                temp >>= 1;
                co++;
            }
            ans <<= co;
            ans |= i;
            ans %= mod;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        ConcatenationofConsecutiveBinaryNumbers c=new ConcatenationofConsecutiveBinaryNumbers();
        System.out.println(c.concatenatedBinary(100000));
    }
}
