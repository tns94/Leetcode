package january21;
/*
https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3619/
 */
public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] string=new char[n];
        k=k-n;
        int zCount=k/25;
        int mid = k%25;
        int i=n-1;
        while(zCount-->0){
            string[i--]='z';
        }
        if(mid>0)
            string[i--]=(char)('a'+mid);
        while(i>=0){
            string[i--]='a';
        }
        return new String(string);
    }
}
