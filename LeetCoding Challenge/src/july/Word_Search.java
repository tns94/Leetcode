package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3397/
 */
public class Word_Search {
    int[][] arr={{-1,0},{0,-1},{1,0},{0,1}};
    boolean isValidIndex(int x,int y,int xMax,int yMax)
    {
        if(x<0 || x>=xMax || y<0 || y>=yMax)
            return false;
        return true;
    }
    public boolean exist(char[][] board, String word) {
        if(board==null || word ==null)
            return false;
        int xMax=board.length;
        int yMax=board[0].length;
        boolean[][] markBoard=new boolean[xMax][yMax];
        for (int i = 0; i < xMax; i++) {
            for (int j = 0; j < yMax; j++) {

                if(isExist(board,word,0,i,j,markBoard))
                    return true;
            }
        }
        return false;

    }

    boolean isExist(char[][] board,String word,int index,int i,int j,boolean[][] markBoard)
    {
        if(index==word.length())
            return true;

        if(board[i][j]!=word.charAt(index))
            return false;
        else if(index==word.length()-1)
            return true;

        markBoard[i][j]=true;
        for (int k = 0; k < 4; k++) {
            int newI=i-arr[k][0];
            int newJ=j-arr[k][1];
            if( isValidIndex(newI,newJ,board.length,board[0].length) && !markBoard[newI][newJ])
            {
                if(isExist(board,word,index+1,newI,newJ,markBoard))
                    return true;
            }
        }
        markBoard[i][j]=false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Word_Search().exist(board,"SEE"));
    }
}
