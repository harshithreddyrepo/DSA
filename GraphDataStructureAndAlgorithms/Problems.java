package DSA_with_kunal.GraphDataStructureAndAlgorithms;

import java.util.*;

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

    // Q5.01 Matrix
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Cell> queue=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0){
                    queue.offer(new Cell(i, j));
                    visited[i][j]=true;
                }
            }
        }

        int minDist=1;

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                Cell cur=queue.poll();
                int row=cur.row;
                int col=cur.col;
                //TOP
                if(row>0  && !visited[row-1][col]){
                    mat[row-1][col]=minDist;
                    visited[row-1][col]=true;
                    queue.offer(new Cell(row-1, col));
                }
                //RIGHT
                if(col<n-1 && !visited[row][col+1]){
                    mat[row][col+1]=minDist;
                    visited[row][col+1]=true;
                    queue.offer(new Cell(row, col+1));
                }
                //BOTTOM
                if(row<m-1 && !visited[row+1][col]){
                    mat[row+1][col]=minDist;
                    visited[row+1][col]=true;
                    queue.offer(new Cell(row+1, col));
                }
                //LEFT
                if(col>0 && !visited[row][col-1]){
                    mat[row][col-1]=minDist;
                    visited[row][col-1]=true;
                    queue.offer(new Cell(row, col-1));
                }
            }
            minDist++;
        }
        return mat;
    }

    // Q6.Surrounded Regions
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        Queue<Cell> queue=new ArrayDeque<>();
        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                queue.offer(new Cell(i, 0));
                board[i][0]='Y';
            }
            if(board[i][n-1]=='O'){
                queue.offer(new Cell(i, n-1));
                board[i][n-1]='Y';
            }
        }
        for(int j=0; j<n; j++){
            if(board[0][j]=='O'){
                queue.offer(new Cell(0, j));
                board[0][j]='Y';
            }
            if(board[m-1][j]=='O'){
                queue.offer(new Cell(m-1, j));
                board[m-1][j]='Y';
            }
        }

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                Cell cur=queue.poll();
                int row=cur.row;
                int col=cur.col;

                // Top
                if(row>0 && board[row-1][col]=='O'){
                    queue.offer(new Cell(row-1, col));
                    board[row-1][col]='Y';
                }
                // Right
                if(col<n-1 && board[row][col+1]=='O'){
                    queue.offer(new Cell(row, col+1));
                    board[row][col+1]='Y';
                }
                // Down
                if(row<m-1 && board[row+1][col]=='O'){
                    queue.offer(new Cell(row+1, col));
                    board[row+1][col]='Y';
                }
                // Left
                if(col>0 && board[row][col-1]=='O'){
                    queue.offer(new Cell(row, col-1));
                    board[row][col-1]='Y';
                }

            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='Y'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }

    // Q7.Is Graph Bipartite
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        boolean result = true;
        for (int i = 0; i < n; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                result = result && dfs(i, 0, visited, graph);
            }
        }
        return result;
    }

    private boolean dfs(int node, int color, int[] visited, int[][] graph) {
        visited[node] = color;
        for (int i = 0; i < graph[node].length; i++) {
            // Adjacent un-visited node
            if (visited[graph[node][i]] == -1) {
                int newColor = color == 1 ? 0 : 1;
                boolean val = dfs(graph[node][i], newColor, visited, graph);
                if (!val)
                    return false;
            } else if (visited[graph[node][i]] == color) {
                return false;
            }
        }
        return true;
    }

    // Q8.Eventual Safe Node
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] visited=new int[n];
        int[] pathVisited=new int[n];
        int[] safeNode=new int[n];
        List<Integer> result=new ArrayList<>();

        for(int i=0; i<n; i++){
            if(visited[i]==0){
                dfs(i, visited, pathVisited, safeNode, graph);
            }
        }

        for(int i=0; i<n; i++){
            if(safeNode[i]==1){
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int node, int[] visited, int[] pathVisited, int[] safeNode, int[][] graph){
        visited[node]=1;
        pathVisited[node]=1;

        for(int i=0; i<graph[node].length; i++){
            // Visited and Path Visited => Cycle Detected
            if(visited[graph[node][i]]==1 && pathVisited[graph[node][i]]==1){
                return true;
            }else if(visited[graph[node][i]]==0){
                // Un-visited node
                if(dfs(graph[node][i], visited, pathVisited, safeNode, graph)){
                    return true;
                }
            }
        }


        pathVisited[node]=0;
        safeNode[node]=1;
        return false;
    }
}
