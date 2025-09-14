package DSA_with_kunal.Recursion.concept.SubsetPattern.MazeGame;

public class Main {
    public static void main(String[] args) {
        System.out.println(countingPaths(3,3));
        System.out.println(countingPaths2(3,3));

    }
    // Only right and down moves are allowed.
    public static int countingPaths(int row,int col){
        if(row==1||col==1){
            return 1;
        }
        int rightPathCount=countingPaths(row,col-1);
        int downPathCount=countingPaths(row-1,col);
        return rightPathCount+downPathCount;
    }

    // Right, down and diagonal moves are allowed.
    public static int countingPaths2(int row,int col){
        if(row==1||col==1){
            return 1;
        }
        int rightPathCount=countingPaths2(row,col-1);
        int downPathCount=countingPaths2(row-1,col);
        int diagonalPathCount=countingPaths2(row-1,col-1);
        return rightPathCount+downPathCount+diagonalPathCount;
    }
    
}
