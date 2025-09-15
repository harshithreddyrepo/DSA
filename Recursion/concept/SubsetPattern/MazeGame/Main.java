package DSA_with_kunal.Recursion.concept.SubsetPattern.MazeGame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //  System.out.println(countingPaths(3,3));
        //  System.out.println(countingPaths2(3,3));
        //  System.out.println(printingPaths("",3,3));
        //   System.out.println(printingPaths2("",3,3));
        boolean[][] boolMat = {{true, true, true}, {true, false, false}, {true, true, true}};
        // System.out.println(countingPaths3(0, 0, boolMat));
        System.out.println(countingPaths4(0, 0, boolMat));
        // System.out.println(printingPaths3("",0,0,boolMat));

    }

    // Only right and down moves are allowed.
    public static int countingPaths(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int rightPathCount = countingPaths(row, col - 1);
        int downPathCount = countingPaths(row - 1, col);
        return rightPathCount + downPathCount;
    }

    // Right, down and diagonal moves are allowed.
    public static int countingPaths2(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int rightPathCount = countingPaths2(row, col - 1);
        int downPathCount = countingPaths2(row - 1, col);
        int diagonalPathCount = countingPaths2(row - 1, col - 1);
        return rightPathCount + downPathCount + diagonalPathCount;
    }

    // Only right and down moves are allowed. R-right, D-down
    public static List<String> printingPaths(String p, int row, int col) {
        List<String> list = new ArrayList<>();
        if (row == 1 && col == 1) {
            list.add(p);
            return list;
        }
        if (row > 1)
            list.addAll(printingPaths(p + "D", row - 1, col));
        if (col > 1)
            list.addAll(printingPaths(p + "R", row, col - 1));

        return list;
    }

    // Right, down and diagonal moves are allowed. R-right, D-down, DIA-diagonal
    public static List<String> printingPaths2(String p, int row, int col) {
        List<String> list = new ArrayList<>();
        if (row == 1 && col == 1) {
            list.add(p);
            return list;
        }
        if (row > 1)
            list.addAll(printingPaths2(p + "D", row - 1, col));
        if (col > 1)
            list.addAll(printingPaths2(p + "R", row, col - 1));
        if (row > 1 && col > 1)
            list.addAll(printingPaths2(p + "DIA", row - 1, col - 1));
        return list;
    }

    //=========* Maze with obstacles *==========//

    // Only right and down moves are allowed.
    public static int countingPaths3(int row, int col, boolean[][] arr) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return 1;
        }
        if (arr[row][col] == false) {
            return 0;
        }

        int rightCount = 0;
        if (col < arr[0].length - 1) {
            rightCount = countingPaths3(row, col + 1, arr);
        }
        int downCount = 0;
        if (row < arr.length - 1) {
            downCount = countingPaths3(row + 1, col, arr);
        }
        return rightCount + downCount;
    }

    // Right, down and diagonal moves are allowed. R-right, D-down
    public static int countingPaths4(int row, int col, boolean[][] arr) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return 1;
        }
        if (arr[row][col] == false) {
            return 0;
        }
        int diagonalCout = 0;
        if (row < arr.length - 1 && col < arr[0].length - 1) {
            diagonalCout = countingPaths4(row + 1, col + 1, arr);
        }
        int rightCount = 0;
        if (col < arr[0].length - 1) {
            rightCount = countingPaths4(row, col + 1, arr);
        }
        int downCount = 0;
        if (row < arr.length - 1) {
            downCount = countingPaths4(row + 1, col, arr);
        }
        return rightCount + downCount + diagonalCout;
    }

    // Only right and down moves are allowed. ( R-right, D-down, DIA-diagonal )
    public static List<String> printingPaths3(String p, int row, int col, boolean[][] arr) {
        List<String> path = new ArrayList<>();
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            path.add(p);
            return path;
        }
        if (arr[row][col] == false) {
            return path;
        }
        if (row < arr.length - 1) {
            path.addAll(printingPaths3(p + "D", row + 1, col, arr));
        }
        if (col < arr[0].length - 1) {
            path.addAll(printingPaths3(p + "R", row, col + 1, arr));
        }
        return path;
    }


}
