package july;

public class Prison_Cells_After_N_Days {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(N==0)
            return cells;
        int[][] cellList=new int[15][8];
        cellList[0]=cells;
        for (int i = 1; i <= 14; i++) {
            int[] tempCells=new int[8];
            for (int j = 1; j < 7; j++) {
                if((cells[j-1] ^ cells[j+1]) == 0)
                    tempCells[j]=1;
            }
            cells=tempCells;
            cellList[i]=tempCells;
        }
        return cellList[N % 14 == 0 ? 14 : N % 14];
    }
}
