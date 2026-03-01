package DSA_with_kunal.GraphDataStructureAndAlgorithms;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problems {
    // Q1.Number of Provinces
    public int findCircleNum(int[][] isConnected) {
        int province=0;
        int n = isConnected.length;
        boolean[] visited=new boolean[n];
        for(int city=1; city<=n; city++){
            if(!visited[city-1]){
                dfs(isConnected, visited, city-1);
                province++;
            }
        }
        return province;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city]=true;
        for(int i=0; i<isConnected[city].length; i++){
            if(isConnected[city][i]==1 && !visited[i]){
                dfs(isConnected, visited, i);
            }
        }
    }

    // Q2.Number of Islands
    public int numIslands(char[][] grid) {
        int islandCount=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    islandCount++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandCount;
    }
    public void dfs(char[][] grid, int row, int col){
        grid[row][col]='0';
        // RIGHT
        if(col<grid[row].length-1 && grid[row][col+1]=='1') dfs(grid, row, col+1);

        // DOWN
        if(row<grid.length-1 && grid[row+1][col]=='1') dfs(grid, row+1, col);

        // TOP
        if(row>0 && grid[row-1][col]=='1') dfs(grid, row-1, col);

        // LEFT
        if(col>0 && grid[row][col-1]=='1') dfs(grid, row, col-1);

    }

    // Q3.Flood Fill
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        int prevColor=image[sr][sc];
        dfs(image, sr, sc, color, prevColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int prevColor){
        image[sr][sc]=color;

        // TOP
        if(sr>0 && image[sr-1][sc]==prevColor) dfs(image, sr-1, sc, color, prevColor);

        // LEFT
        if(sc>0 && image[sr][sc-1]==prevColor) dfs(image, sr, sc-1, color, prevColor);

        // DOWN
        if(sr<image.length-1 && image[sr+1][sc]==prevColor) dfs(image, sr+1, sc, color, prevColor);

        // RIGHT
        if(sc<image[sr].length-1 && image[sr][sc+1]==prevColor) dfs(image, sr, sc+1, color, prevColor);
    }

    // Q4.Rotten Oranges
    class Cell{
        private int row;
        private int col;
        public Cell(int row, int col){
            this.col=col;
            this.row=row;
        }
        public int getRow(){
            return row;
        }
        public int getCol(){
            return col;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Cell> queue=new ArrayDeque<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==2){
                    Cell cell=new Cell(i, j);
                    queue.offer(cell);
                }
            }
        }

        int time=0;
        while(!queue.isEmpty()){
            int curRottenCount=queue.size();
            for(int k=0; k<curRottenCount; k++){
                Cell cell=queue.poll();
                int row=cell.getRow();
                int col=cell.getCol();
                // TOP
                if(row>0 && grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    queue.offer(new Cell(row-1, col));
                }
                // LEFT
                if(col>0 && grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    queue.offer(new Cell(row, col-1));
                }
                // DOWN
                if(row<grid.length-1 && grid[row+1][col]==1){
                    grid[row+1][col]=2;
                    queue.offer(new Cell(row+1, col));
                }
                // RIGHT
                if(col<grid[row].length-1 && grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    queue.offer(new Cell(row, col+1));
                }
            }

            if(!queue.isEmpty()) time++;

        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time;
    }
}
