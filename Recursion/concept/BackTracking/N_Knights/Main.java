package DSA_with_kunal.Recursion.concept.BackTracking.N_Knights;

public class Main {
    public static void main(String[] args) {
       boolean[][] board=new boolean[3][3];
        System.out.println(nKnightsCount(board,0,0,0));
    }

    public static int nKnightsCount(boolean[][] board, int row, int col, int k){
       if(k>=board.length){
           for(boolean[] r:board){
               for(boolean val:r){
                   if(val){
                       System.out.print("K ");
                   }else{
                       System.out.print("* ");
                   }
               }
               System.out.println();
           }
           System.out.println("=======================");
           return 1;
       }
       if(row>=board.length){
           return 0;
       }
       int count=0;
       if(col>=board[0].length){
           count=nKnightsCount(board,row+1,0,k);
           return count;
       }
       if(checkVlaidCell(board,row,col)){
           if(col<board[0].length-1){
               board[row][col]=true;
               count=nKnightsCount(board,row,col+1,k+1);
               board[row][col]=false;
           }else{
               board[row][col]=true;
               count+=nKnightsCount(board,row+1,0,k+1);
               board[row][col]=false;
           }
       }
       count+=nKnightsCount(board,row,col+1,k);
       return count;
    }


    private static boolean checkVlaidCell(boolean[][] board, int row, int col) {

        // row -2 and col -1
        if(row-2>=0 && col-1>=0){
            if(board[row-2][col-1]){
                return false;
            }
        }
        // row -2 and col +1
        if(row-2>=0 && col+1<board.length){
            if(board[row-2][col+1]){
                return false;
            }
        }
        // row -1 and col -2
        if(row-1>=0 && col-2>=0){
            if(board[row-1][col-2]){
                return false;
            }
        }
        // row -1 and col +2
        if(row-1>=0 && col+2<board[0].length){
            if(board[row-1][col+2]){
                return false;
            }
        }
        return true;
    }
}
