package DSA_with_kunal.Recursion.concept.BackTracking.SudokuSolver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] sudoku = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
//        sudokuSolver1(sudoku,0,0);

        sudokuSolver2(sudoku);
        for(char[] r:sudoku){
            System.out.println(Arrays.toString(r));
        }
    }

    public static boolean sudokuSolver1(char[][] board, int row, int col){
        if (row == board.length) {
            return true;
        }
        if (col == board[0].length) {
            return sudokuSolver1(board, row + 1, 0);
        }
        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (checkValid(board, row, col, (char)(i + '0'))) {
                    board[row][col] = (char)(i + '0');
                    if (sudokuSolver1(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        } else {
            return sudokuSolver1(board, row, col + 1);
        }
    }

    public static boolean sudokuSolver2(char[][] board){
        boolean emptyCell=false;
        int row=-1;
        int col=-1;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    row=i;
                    col=j;
                    emptyCell=true;
                    break;
                }
            }
            if(emptyCell){
                break;
            }
        }
        if(!emptyCell){
            return true;
        }
        for (int i=1;i<10;i++){
            if(checkValid(board,row,col,(char)(i+'0'))){
                board[row][col]=(char)(i+'0');
                if(sudokuSolver2(board)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }

    public static boolean checkValid(char[][] board, int row, int col, char ch){
        // check row
        for(int i=0;i< board[0].length;i++){
            if(board[row][i]==ch){
                return false;
            }
        }
        // check column
        for(int i=0;i< board.length;i++){
            if(board[i][col]==ch){
                return false;
            }
        }
        // check box
        int rowStart=row-row%3;
        int colStart=col-col%3;
        for(int r=rowStart;r<rowStart+3;r++){
            for(int c=colStart;c<colStart+3;c++){
                if(board[r][c]==ch){
                    return false;
                }
            }
        }
        return true;
    }

}
