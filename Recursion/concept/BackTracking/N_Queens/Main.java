package DSA_with_kunal.Recursion.concept.BackTracking.N_Queens;

public class Main {
    public static void main(String[] args) {
       boolean[][] board=new boolean[4][4];
       // System.out.println(nQueensCount1( board,0));
        System.out.println(nQueensCount2(board,0,0));
    }


    // Using for-loop
    public static int nQueensCount1(boolean[][] board,int row){
        if(row==board.length){
            return 1;
        }
        int count=0;
        for(int col=0;col<board[0].length;col++){
            if(validCell(row, col,board)){
                board[row][col]=true;
                 count+=nQueensCount1(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }

    // Without using for-loop (i.e. purely recursive)
    public static int nQueensCount2(boolean[][] board, int row, int col){
        // Base condition (Bottom up recursion)
        if(row==board.length){
            return 1;
        }
        if(col==board[0].length){
            return 0;
        }
        int count=0;
        if(validCell(row, col, board )){
            board[row][col]=true;
            count+=nQueensCount2(board,row+1,0);
            board[row][col]=false;
        }
        count+=nQueensCount2(board,row,col+1);
        return count;
    }

    public static boolean validCell(int row,int col,boolean[][] board){
        // check column
        for(int r=0;r<row;r++){
            if(board[r][col]){
                return false;
            }
        }

        // check left diagonal
        int r=row;
        int c=col;
        while(r>0 && c>0){
            if(board[--r][--c]){
                return false;
            }
        }

        // check right diagonal
        r=row;
        c=col;
        while (r>0 && c<board[0].length-1){
            if(board[--r][++c]){
                return false;
            }
        }

        return true;
    }

}
