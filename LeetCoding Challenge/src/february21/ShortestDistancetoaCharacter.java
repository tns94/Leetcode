package february21;
/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3631/
 */
public class ShortestDistancetoaCharacter {
    public static int[] shortestToChar(String s, char c) {
        char[] arr=s.toCharArray();
        int[] ans=new int[arr.length];
        int dis=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==c)
                dis=0;
            ans[i]=dis;
            if(dis>=0) dis++;
        }
        dis=-1;
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i]==c)
                dis=0;
            if(dis >= 0){
                if(ans[i] < 0)
                    ans[i]=dis;
                else
                    ans[i]=Math.min(dis,ans[i]);
                dis++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        shortestToChar("aaa",'e');
    }
}
