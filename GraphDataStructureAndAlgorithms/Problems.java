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

    // Q9.Course Schedule
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Cycle Detection in Directed Graph (DFS)
        boolean[] visited=new boolean[numCourses];
        boolean[] pathVisited=new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                // Cycle Detected => Return false
                if(dfs(i, visited, pathVisited, adjList)){
                    return false;
                }
            }
        }
        // DAG => Return flase
        return true;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adjList){
        visited[node]=true;
        pathVisited[node]=true;
        for(int adj : adjList.get(node)){
            if(visited[adj] && pathVisited[adj]) return true;
            if(!visited[adj]){
                if(dfs(adj, visited, pathVisited, adjList)) return true;
            }
        }
        pathVisited[node]=false;
        return false;
    }

    // Q10.Course Schedule II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Topological Sort (BFS)
        int[] inDegree=new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0) queue.offer(i);
        }
        List<Integer> list=new ArrayList<>();

        while(!queue.isEmpty()){
            int node=queue.poll();
            list.add(node);
            for(int adj:adjList.get(node)){
                inDegree[adj]--;
                if(inDegree[adj]==0) queue.offer(adj);
            }
        }

        if(list.size()<numCourses) return new int[]{};

        int[] result=new int[numCourses];
        for(int i=0; i<numCourses; i++){
            result[i]=list.get(i);
        }

        return result;
    }

    // Q11.Alien Dictionary
    public String findOrder(String[] words) {

        List<Character[]> edgeList = new ArrayList<>();

        Map<Character, List<Character>> adjList=new HashMap<>();

        Map<Character, Integer> inDegree=new HashMap<>();

        Set<Character> set=new HashSet<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                set.add(c);
                inDegree.put(c, 0);
            }
        }


        for(int i=0; i<words.length-1; i++){
            int len=Math.min(words[i].length(), words[i+1].length());
            int j=0;
            while(j<len && words[i].charAt(j)==words[i+1].charAt(j)){
                j++;
            }

            if (j == len && words[i].length() > words[i+1].length()) {
                return "";
            }

            if(j<len) edgeList.add(new Character[]{words[i].charAt(j),words[i+1].charAt(j)});
        }

        for(Character[] edge:edgeList){
            char u=edge[0];
            char v=edge[1];

            // Adj List
            if(adjList.containsKey(u)){
                adjList.get(u).add(v);
            }else{
                adjList.put(u, new ArrayList<>());
                adjList.get(u).add(v);
            }

            // In-Degree
            inDegree.put(v, inDegree.get(v) + 1);
        }

        StringBuilder result=new StringBuilder("");
        Queue<Character> queue=new ArrayDeque<>();
        for(Character key : inDegree.keySet()){
            if(inDegree.get(key)==0){
                queue.offer(key);
            }
        }

        while(!queue.isEmpty()){
            char ch=queue.poll();
            result.append(ch);
            List<Character> adjs=adjList.getOrDefault(ch, new ArrayList<>());
            for(char adj:adjs){
                inDegree.put(adj, inDegree.get(adj)-1);
                if(inDegree.get(adj)==0) queue.offer(adj);
            }
        }

        if(result.length()==set.size()){
            return result.toString();
        }else{
            return "";
        }
    }

    // Q12.Word Ladder
    class WordPair{
        String word;
        int dist;
        public WordPair(String word, int dist){
            this.word=word;
            this.dist=dist;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        int len=1;
        if(!set.contains(endWord)) return 0;
        if(beginWord==endWord) return 1;

        Queue<WordPair> queue=new ArrayDeque<>();
        queue.offer(new WordPair(beginWord,1));
        set.remove(beginWord);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                WordPair cur=queue.poll();
                String word=cur.word;
                if(word.equals(endWord)) return cur.dist;
                for(int j=0; j<word.length(); j++){
                    for(int k=0; k<26; k++){
                        String adjWord = word.substring(0,j) + (char)('a'+k) + word.substring(j+1);
                        if(set.contains(adjWord)){
                            queue.offer(new WordPair(adjWord, len+1));
                            set.remove(adjWord);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }

    // Dijkstra Algorithm
    class  Pair2{
        int node;
        int dist;
        public Pair2(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        Map<Integer, List<Pair2>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            // [u, v, distance]
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(new Pair2(edge[1], edge[2]));

            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>())
                    .add(new Pair2(edge[0], edge[2]));
        }

        PriorityQueue<Pair2> minHeap=new PriorityQueue<>((a, b)-> {
            if(a.dist!=b.dist){
                return a.dist-b.dist;
            }else{
                return a.node-b.node;
            }
        });

        int[] result=new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[src]=0;
        minHeap.offer(new Pair2(src, 0));

        while(!minHeap.isEmpty()){
            Pair2 cur=minHeap.poll();
            List<Pair2> adjNodes=adjList.get(cur.node);
            for(Pair2 adj:adjNodes){
                if(result[adj.node]>cur.dist+adj.dist){
                    result[adj.node]=cur.dist+adj.dist;
                    minHeap.offer(new Pair2(adj.node, result[adj.node]));
                }
            }
        }
        return result;
    }

    // Q13.Shortest Path in an Undirected Graph
    // Method 1: PriorityQueue
    public List<Integer> shortestPathPriorityQueue(int n, int m, int edges[][]) {

        int[] distance=new int[n+1];

        int[] parent=new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i]=i;
        }

        Map<Integer, List<int[]>> adjList=new HashMap<>();

        for(int edge[] : edges){

            adjList.computeIfAbsent(edge[0],  k -> new ArrayList<>())
                    .add(new int[]{edge[2], edge[1]}); // {distance ,node}

            adjList.computeIfAbsent(edge[1],  k -> new ArrayList<>())
                    .add(new int[]{edge[2], edge[0]}); // {distance ,node}
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[1]=0;

        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a, b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });

        minHeap.offer(new int[]{0, 1});

        while(!minHeap.isEmpty()){
            int[] node=minHeap.poll();
            List<int[]> adjNodes = adjList.getOrDefault(node[1], new ArrayList<>());
            for(int[] adj:adjNodes){
                if(distance[adj[1]]>node[0]+adj[0]){
                    distance[adj[1]]=node[0]+adj[0];
                    parent[adj[1]]=node[1];
                    minHeap.offer(new int[]{distance[adj[1]], adj[1]});
                }
            }
        }

        List<Integer> result=new ArrayList<>();

        if(distance[n]==Integer.MAX_VALUE){
            result.add(-1);
        }else{
            result.add(n);
            int node=n;
            while(node!=parent[node]){
                node=parent[node];
                result.add(0, node);
            }
            result.add(0, distance[n]);
        }
        return result;
    }

    // Method 2: Set (TreeSet)
    class Pair{

        int node;
        int dist;

        public Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }

        int getNode(){
            return node;
        }

        int getDist(){
            return dist;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {

        List<List<Pair>> adjList=new ArrayList<>();

        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<Pair>());
        }

        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }

        int[] distance=new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1]=0;

        int[] parent=new int[n+1];
        parent[1]=-1;

        TreeSet<Pair> set=new TreeSet<>((a, b)->{
            if(a.getDist()!=b.getDist()){
                return a.getDist()-b.getDist();
            }else{
                return a.getNode()-b.getNode();
            }
        });

        set.add(new Pair(1, 0));

        while(!set.isEmpty()){

            Pair cur=set.pollFirst();
            int node=cur.getNode();
            int dist=cur.getDist();
            // set.remove(cur);

            for(Pair adj : adjList.get(node)){

                int adjNode=adj.getNode();

                int wght=adj.getDist();

                if(distance[adjNode]>dist+wght){

                    if(distance[adjNode]!=Integer.MAX_VALUE){
                        set.remove(new Pair(adjNode, distance[adjNode]));
                    }

                    parent[adjNode]=node;
                    distance[adjNode]=dist+wght;
                    set.add(new Pair(adjNode, dist+wght));
                }
            }
        }

        List<Integer> result=new ArrayList<>();

        if(distance[n]==Integer.MAX_VALUE){
            result.add(-1);
            return result;
        }

        int vertex=n;
        result.add(n);
        while(parent[vertex]!=-1){
            result.add(0, parent[vertex]);
            vertex=parent[vertex];
        }

        result.add(0, distance[n]);

        return result;

    }

    // Q14.Shortest Path in Undirected Graph with Unit Weights
    public int[] shortestPath(int V, int[][] edges, int src) {

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] distance=new int[V];

        Arrays.fill(distance, -1);

        distance[src]=0;

        int dist=1;

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(src);

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                int cur=queue.poll();
                for(int adj:adjList.get(cur)){
                    if(distance[adj]==-1 || distance[adj]>distance[cur]+1){
                        distance[adj]=distance[cur]+1;
                        queue.offer(adj);
                    }
                }
            }
        }

        return distance;
    }

    // Q15.Shortest Path in Binary Matrix
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n=grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        grid[0][0]=1;

        Queue<Cell> queue=new ArrayDeque<>();
        queue.offer(new Cell(0, 0));

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                Cell cur=queue.poll();
                int row=cur.getRow();
                int col=cur.getCol();
                int dist=grid[row][col];
                // Check for adjacent cell containing '0'
                // if present insert it into the queue and update the distance.

                // North
                if(row>0 && grid[row-1][col]==0){
                    grid[row-1][col]=dist+1;
                    queue.offer(new Cell(row-1, col));
                }
                // North-East
                if((row>0 && col<n-1) && grid[row-1][col+1]==0){
                    grid[row-1][col+1]=dist+1;
                    queue.offer(new Cell(row-1, col+1));
                }
                // East
                if(col<n-1 && grid[row][col+1]==0){
                    grid[row][col+1]=dist+1;
                    queue.offer(new Cell(row, col+1));
                }
                // South-East
                if((row<n-1 && col<n-1) && grid[row+1][col+1]==0){
                    grid[row+1][col+1]=dist+1;
                    queue.offer(new Cell(row+1, col+1));
                }
                // South
                if(row<n-1 && grid[row+1][col]==0){
                    grid[row+1][col]=dist+1;
                    queue.offer(new Cell(row+1, col));
                }
                // South-West
                if((row<n-1 && col>0) && grid[row+1][col-1]==0){
                    grid[row+1][col-1]=dist+1;
                    queue.offer(new Cell(row+1, col-1));
                }
                // West
                if(col>0 && grid[row][col-1]==0){
                    grid[row][col-1]=dist+1;
                    queue.offer(new Cell(row, col-1));
                }
                // North-West
                if((row>0 && col>0) && grid[row-1][col-1]==0){
                    grid[row-1][col-1]=dist+1;
                    queue.offer(new Cell(row-1, col-1));
                }


            }
        }

        if(grid[n-1][n-1]==0){
            return -1;
        }
        return grid[n-1][n-1];

    }

    // Q16.Path with Minimum Effort
    class AbsCell{
        int row;
        int col;
        int absDiff;
        public AbsCell(int row, int col, int absDiff){
            this.row=row;
            this.col=col;
            this.absDiff=absDiff;
        }
        int getRow(){
            return row;
        }
        int getCol(){
            return col;
        }
        int getAbsDiff(){
            return absDiff;
        }
    }
    public int minimumEffortPath(int[][] heights) {

        int rows=heights.length;
        int columns=heights[0].length;

        int[][] maxAbsDiff=new int[rows][columns];
        //  Arrays.fill(maxAbsDiff, Integer.MAX_VALUE);
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                maxAbsDiff[i][j]=Integer.MAX_VALUE;
            }
        }
        maxAbsDiff[0][0]=0;

        TreeSet<AbsCell> set = new TreeSet<>((a, b) -> {
            if (a.absDiff != b.absDiff) return a.absDiff - b.absDiff;
            if (a.row != b.row) return a.row - b.row;
            return a.col - b.col;
        });
        set.add(new AbsCell(0, 0, 0));

        int[] dltRow={-1, 0, 1, 0};
        int[] dltCol={0, 1, 0, -1};

        while(!set.isEmpty()){
            AbsCell cur=set.pollFirst();
            int row=cur.getRow();
            int col=cur.getCol();
            int absDiff=cur.getAbsDiff();

            for(int i=0; i<4; i++){
                int newRow=row+dltRow[i];
                int newCol=col+dltCol[i];
                if((newRow>=0 && newRow<rows) && (newCol>=0 && newCol<columns)){

                    int curAbsDiff=Math.abs(heights[row][col]-heights[newRow][newCol]);
                    int effortToReachNewCell=Math.max(absDiff, curAbsDiff);

                    if(effortToReachNewCell<maxAbsDiff[newRow][newCol]){
                        if(maxAbsDiff[newRow][newCol]!=Integer.MAX_VALUE){
                            set.remove(new AbsCell(newRow, newCol, maxAbsDiff[newRow][newCol]));
                        }
                        maxAbsDiff[newRow][newCol]=Math.max(absDiff, curAbsDiff);
                        set.add(new AbsCell(newRow, newCol, maxAbsDiff[newRow][newCol]));
                    }
                }
            }

        }

        return maxAbsDiff[rows-1][columns-1];


    }

    // Q17.Cheapest Flights within K Stops
    class KstopPair{
        int city;
        int price;
        int stop;
        public KstopPair(int city, int price, int stop){
            this.city=city;
            this.price=price;
            this.stop=stop;
        }
        int getCity(){
            return city;
        }
        int getPrice(){
            return price;
        }
        int getStop(){
            return stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<KstopPair>> adjList=new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<KstopPair>());
        }
        for(int[] flight:flights){
            adjList.get(flight[0]).add(new KstopPair(flight[1], flight[2], 0));
        }

        int[] cost=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;

        Queue<KstopPair> queue=new ArrayDeque<>();
        queue.offer(new KstopPair(src, 0, -1));

        while(!queue.isEmpty()){
            KstopPair cur=queue.poll();
            int curCity=cur.getCity();
            int curCost=cur.getPrice();
            int curStop=cur.getStop();
            if(curStop<k){
                for(KstopPair adj:adjList.get(curCity)){
                    int adjCity=adj.getCity();
                    int newCost=curCost+adj.getPrice();
                    if(newCost<cost[adjCity]){
                        cost[adjCity]=newCost;
                        queue.offer(new KstopPair(adjCity, newCost, curStop+1));
                    }
                }
            }
        }
        if(cost[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return cost[dst];
    }

    // Q18.Minimum Multiplications to Reach End
    public int minSteps(int[] arr, int start, int end) {
        // code here
        int[] minOpn=new int[1000];
        Arrays.fill(minOpn, Integer.MAX_VALUE);
        minOpn[start]=0;

        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int cur=queue.poll();
            for(int n:arr){
                int adj= (cur*n)%1000;
                if(minOpn[adj]>minOpn[cur]+1){
                    minOpn[adj]=minOpn[cur]+1;
                    queue.offer(adj);
                }
            }
        }
        if(minOpn[end]==Integer.MAX_VALUE){
            return -1;
        }
        return minOpn[end];
    }

    // Q19.Number of Ways to Arrive at Destination
    class Pair19{
        int intersection;
        long time;
        public Pair19(int intersection, long time){
            this.intersection=intersection;
            this.time=time;
        }
        int getIntersection(){
            return intersection;
        }
        long getTime(){
            return time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        final int M=1000000007;
        List<List<Pair19>> adjList=new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<Pair19>());
        }
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            int t=road[2];
            adjList.get(u).add(new Pair19(v, t));
            adjList.get(v).add(new Pair19(u, t));
        }

        long[] reqTime=new long[n];
        Arrays.fill(reqTime, Long.MAX_VALUE);
        reqTime[0]=0;

        int[] visitCount=new int[n];
        visitCount[0]=1;

        Queue<Pair19> queue=new PriorityQueue<>((a,b)->{
            if(a.getTime()!=b.getTime()){
                return (int)(a.getTime()-b.getTime());
            }else{
                return a.getIntersection()-b.getIntersection();
            }
        });
        queue.offer(new Pair19(0, 0));

        while(!queue.isEmpty()){

            Pair19 cur=queue.poll();
            int intersection=cur.getIntersection();
            long timeTaken=cur.getTime();

            for(Pair19 adj:adjList.get(intersection)){

                int adjInt=adj.getIntersection();
                long timeToReach=timeTaken+adj.getTime();

                if(reqTime[adjInt]>timeToReach){
                    visitCount[adjInt]=visitCount[intersection];
                    reqTime[adjInt]=timeToReach;
                    queue.offer(new Pair19(adjInt, timeToReach));
                }else if(reqTime[adjInt]==timeToReach){
                    visitCount[adjInt] = (visitCount[adjInt] + visitCount[intersection]) % M;
                    // queue.offer(new Pair(adjInt, timeToReach));
                }
            }
        }
        return visitCount[n-1];
    }

}
