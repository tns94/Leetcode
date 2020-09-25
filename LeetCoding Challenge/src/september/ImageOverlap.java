package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3450/
 */
public class ImageOverlap {
    private int overLapChecker(int[][] A, int[][] B,int x,int y)
    {
        int counter1=0;
        int counter2=0;

        int dimension=A.length;

        for (int i = x,p=0; i < dimension; i++,p++) {
            for (int j = y,q=0; j < dimension; j++,q++) {
                if(A[p][q]==1 && B[i][j]==1)
                    counter1++;
                if(A[i][j]==1 && B[p][q]==1)
                    counter2++;
            }
        }
        return Math.max(counter1, counter2);
    }
    public int largestOverlap(int[][] A, int[][] B) {
        int max=0;
        int dimension=A.length;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                max= Math.max(max,overLapChecker(A,B,i,j));
            }
        }
        return max;
    }
}
