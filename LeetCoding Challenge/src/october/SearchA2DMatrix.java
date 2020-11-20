package october;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len= matrix.length;
        if(len==0 || matrix[0].length==0)
            return false;
        int[] array = new int[matrix.length];

        if(target < matrix[0][0] || matrix[len-1][matrix[0].length-1] < target)
            return false;
        for (int i = 0; i < matrix.length; i++) {
            array[i] = matrix[i][0];
        }
        int rowIndex= binarySearch(array,target);
        int index = binarySearch(matrix[rowIndex],target);
        if(matrix[rowIndex][index] == target)
            return true;
        return false;
    }
    int binarySearch(int[] array, int target)
    {
        int i=0,j=array.length-1;
        int mid = i+((j-i)/2);
        while (i<=j)
        {
            mid = i+((j-i)/2);
            if(target > array[mid])
                i = mid+1;
            else if (target < array[mid])
                j = mid-1;
            else
                return mid;
        }
        return j;
    }

    public static void main(String[] args) {
        SearchA2DMatrix search=new SearchA2DMatrix();
        System.out.println(search.searchMatrix(new int[][]{{1,3}},3));
    }
}
