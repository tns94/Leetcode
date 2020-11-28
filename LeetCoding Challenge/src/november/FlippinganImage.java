package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3526/
 */
public class FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int j=0,k=A[i].length-1;
            while (j<=k)
            {
                int temp=A[i][j]==0?1:0;
                A[i][j++]=A[i][k]==0?1:0;
                A[i][k++]=temp;
            }
        }
        return A;
    }
}
