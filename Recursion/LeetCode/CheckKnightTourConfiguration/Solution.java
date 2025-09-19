package DSA_with_kunal.Recursion.LeetCode.CheckKnightTourConfiguration;

class Solution {
    public static void main(String[] args) {
        int[][] grid= {
                {8, 3, 6},
                {5, 0, 1},
                {2, 7, 4}
        };
        System.out.println(checkValidGrid(grid));
    }
    public static boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0){
            return false;
        }
        return helper(grid,0,0,0);
    }

    public static boolean helper(int[][] grid, int row, int col, int move){
        if(move>=grid.length*grid.length-1){
            return true;
        }
        // row-2 && col-1
        if(row-2>=0 && col-1>=0){
            if(grid[row-2][col-1]==move+1){
                return helper(grid,row-2,col-1,move+1);
            }
        }
        // row-2 && col+1
        if(row-2>=0 && col+1<grid[0].length){
            if(grid[row-2][col+1]==move+1){
                return helper(grid,row-2,col+1,move+1);
            }
        }
        // row-1 && col-2
        if(row-1>=0 && col-2>=0){
            if(grid[row-1][col-2]==move+1){
                return helper(grid,row-1,col-2,move+1);
            }
        }
        // row-1 && col+2
        if(row-1>=0 && col+2<grid[0].length){
            if(grid[row-1][col+2]==move+1){
                return helper(grid,row-1,col+2,move+1);
            }
        }
        // row+1 && col-2
        if(row+1<grid.length && col-2>=0){
            if(grid[row+1][col-2]==move+1){
                return helper(grid,row+1,col-2,move+1);
            }
        }
        // row+1 && col+2
        if(row+1<grid.length && col+2<grid[0].length){
            if(grid[row+1][col+2]==move+1){
                return helper(grid,row+1,col+2,move+1);
            }
        }
        //row+2 && col-1
        if(row+2<grid.length && col-1>=0){
            if(grid[row+2][col-1]==move+1){
                return helper(grid,row+2,col-1,move+1);
            }
        }
        // row+2 && col+1
        if(row+2<grid.length && col+1<grid[0].length){
            if(grid[row+2][col+1]==move+1){
                return helper(grid,row+2,col+1,move+1);
            }
        }
        return false;
    }

}
