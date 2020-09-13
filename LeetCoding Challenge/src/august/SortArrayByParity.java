package august;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int j=A.length-1,i=0;

        while (i<j && A[i]%2==0)
            i++;
        while (j>=0 && A[j]%2!=0)
            j--;

        while(i<j){
            int temp= A[i];
            A[i]=A[j];
            A[j]=temp;

            while (i<j && A[i]%2==0)
                i++;
            while (j>=0 && A[j]%2!=0)
                j--;
        }
        return A;
    }

    public static void main(String[] args) {
        new SortArrayByParity().sortArrayByParity(new int[]{0});
        System.out.println();
    }
}
