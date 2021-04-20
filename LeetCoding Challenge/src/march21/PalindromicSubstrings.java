package march21;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3686/
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        char[] arr=s.toCharArray();
        int ans=0;
        for (int i = 0; i < arr.length; i++) {
            ans += countPalindromes(arr,i,i) + countPalindromes(arr,i,i+1);
        }
        return ans;
    }
    int countPalindromes(char[] arr,int i,int j){
        int co=0;
        while (i >= 0 && j < arr.length && arr[i--]==arr[j++])
            co++;
        return co;
    }
}
