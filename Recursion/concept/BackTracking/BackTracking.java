package DSA_with_kunal.Recursion.concept.BackTracking;

public class BackTracking {
    public static void main(String[] args) {
        boolean[][] boolMat = {{true, true, true}, {true, true, true}, {true, true, true}};
       // System.out.println(countingPaths(0,0,boolMat));
        printMatrixAndPaths("",new int[3][3],boolMat,0,0,1);
    }

    // All directions are allowed (R-right, D-down, L-left, U-up).
    public static int countingPaths(int row, int col, boolean[][] maze) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            return 1;
        }
        if (maze[row][col] == false) {
            return 0;
        }
        maze[row][col] = false;
        int downCount = 0;
        if (row < maze.length - 1) {
            downCount = countingPaths(row + 1, col, maze);
        }
        int rightCount = 0;
        if (col < maze[0].length-1) {
            rightCount = countingPaths(row, col + 1, maze);
        }
        int upCount = 0;
        if (row > 0) {
            upCount = countingPaths(row - 1, col, maze);
        }
        int leftCount = 0;
        if (col > 0) {
            leftCount = countingPaths(row, col - 1, maze);
        }

        maze[row][col] = true;
        return downCount + rightCount + upCount + leftCount;
    }

    public static void printMatrixAndPaths(String p, int[][] mat,boolean[][] maze,int row, int col,int count){
        if(row==maze.length-1 && col==maze[0].length-1){
            System.out.println(p);
            mat[row][col]=count;
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("=======================");
            return;
        }

        if (maze[row][col] == false) {
            return ;
        }
        maze[row][col] = false;
        mat[row][col]=count;
        // Down
        if (row < maze.length - 1) {
           printMatrixAndPaths(p+"D",mat,maze,row+1,col,count+1);
        }
       // Right
        if (col < maze[0].length-1) {
            printMatrixAndPaths(p+"R",mat,maze,row,col+1,count+1);
        }

        // Up
        if (row > 0) {
            printMatrixAndPaths(p+"U",mat,maze,row-1,col,count+1);
        }

        //Left
        if (col > 0) {
            printMatrixAndPaths(p+"L",mat,maze,row,col-1,count+1);
        }
        mat[row][col]=0;
        maze[row][col] = true;
        return;
    }
}
