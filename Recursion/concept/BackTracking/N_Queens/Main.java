package DSA_with_kunal.Recursion.concept.BackTracking.N_Queens;

public class Main {
    public static void main(String[] args) {
       boolean[][] board=new boolean[5][5];
        System.out.println(nQueensCount( board,0));
    }

    public static int nQueensCount(boolean[][] board,int row){
        if(row==board.length){
            return 1;
        }
        int count=0;
        for(int col=0;col<board[0].length;col++){
            if(validCell(row, col,board)){
                board[row][col]=true;
                 count+=nQueensCount(board,row+1);
                board[row][col]=false;
            }
        }
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
