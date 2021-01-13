package december;
/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3557/
https://leetcode.com/problems/spiral-matrix-ii/solution/
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int start=1;
        int[][] arr=new int[n][n];
        int i=0,j=0;
        int preStart=start;
        while (start<=(n*n))
        {

            preStart=rowFiller(arr,i,j,start,true);
            //print(arr);

            j=j+(preStart-start-1);i++;
            start=preStart;

            preStart=columnFiller(arr,i,j,preStart,true);
           // print(arr);

            i+=(preStart-start-1);j--;
            start=preStart;

            preStart=rowFiller(arr,i,j,preStart,false);
            //print(arr);

            j-=(preStart-start-1);i--;
            start=preStart;

            preStart=columnFiller(arr,i,j,preStart,false);
           // print(arr);

            i-=(preStart-start-1);
            start=preStart;
            j++;
        }
        return arr;
    }
    static int rowFiller(int[][] arr,int i,int j, int start,boolean forward)
    {
        int k=j;
        while(k < arr[i].length && k >=0  && arr[i][k]==0){
            arr[i][k]=start++;
            if(forward) k++;
            else k--;
        }
        return start;
    }
    static int columnFiller(int[][] arr,int i,int j,int start,boolean forward)
    {
        int k=i;
        while(k < arr[j].length && k >=0 && arr[k][j]==0){
            arr[k][j]=start++;
            if(forward) k++;
            else k--;
        }
        return start;
    }
    static void print(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr =new int[5][5];
        generateMatrix(20);
        System.out.println();
    }

}
