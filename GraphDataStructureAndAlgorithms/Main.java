package DSA_with_kunal.GraphDataStructureAndAlgorithms;

import java.util.*;

public class Main {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> result=new ArrayList<>();
        int[] visited=new int[V];
        dfs(adj, 0, visited, result);
        return result;
    }
    private void dfs(List<List<Integer>> adj, int vertix, int[] visited, List<Integer> result){
        result.add(vertix);
        visited[vertix]=1;

        for(int cur: adj.get(vertix)){
            if(visited[cur]!=1) dfs(adj, cur, visited, result);
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];
        List<Integer> result=new ArrayList<>();
        visited[0]=1; // Mark 0th vertix as visited
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int cur=queue.poll();
            result.add(cur);
            for(int i : adj.get(cur)){
                if(visited[i]!=1){
                    queue.offer(i);
                    visited[i]=1;
                }
            }
        }
        return result;
    }

    // Dijkstra Algorithm
    static class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            // [u, v, distance]
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(new Pair(edge[1], edge[2]));

            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>())
                    .add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Pair> minHeap=new PriorityQueue<>((a, b)-> {
            if(a.dist!=b.dist){
                return a.dist-b.dist;
            }else{
                return a.node-b.node;
            }
        });

        int[] result=new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[src]=0;
        minHeap.offer(new Pair(src, 0));

        while(!minHeap.isEmpty()){
            Pair cur=minHeap.poll();
            List<Pair> adjNodes=adjList.get(cur.node);
            for(Pair adj:adjNodes){
                if(result[adj.node]>cur.dist+adj.dist){
                    result[adj.node]=cur.dist+adj.dist;
                    minHeap.offer(new Pair(adj.node, result[adj.node]));
                }
            }
        }
        return result;
    }

    // Bellman-Ford (Negative edge weight)
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist=new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;

        for(int i=0; i<V-1; i++){
            for(int[] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                }
            }
        }

        // Relaxing for nth time to detect the cycle
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+w){
                // dist[v]=dist[u]+w;
                return new int[]{-1};
            }
        }

        // Mark unreachable vertices dist as 10^8
        for(int i=0; i<dist.length; i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=100000000;
            }
        }

        return dist;
    }

    // Floyd Warshall Algorithm (Multi-Source Shortest Path Algorithm)
    public void floydWarshall(int[][] dist) {
        int n=dist.length;
        // int[][] temp=new int[n][n];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         temp[i][j]=dist[i][j];
        //     }
        // }

        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    //  dist[i][j]=Math.min(temp[i][j], temp[i][via]+temp[via][j]);
                    if(dist[i][via]!=100000000 && dist[via][j]!=100000000){
                        dist[i][j]=Math.min(dist[i][j], dist[i][via]+dist[via][j]);
                    }

                }
            }
            // for(int i=0; i<n; i++){
            //   for(int j=0; j<n; j++){
            //         temp[i][j]=dist[i][j];
            //     }
            // }

        }

    }

    // Prims Algorithm (Minimum-Spanning-Tree)
    static class PrimsPair{
        int node;
        int parent;
        int weight;
        public PrimsPair(int node, int parent, int weight){
            this.node=node;
            this.parent=parent;
            this.weight=weight;
        }
        int getNode(){
            return node;
        }
        int getParent(){
            return parent;
        }
        int getWeight(){
            return weight;
        }
    }
    public int spanningTree(int V, int[][] edges) {

        List<List<PrimsPair>> adjList=new ArrayList<>();

        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<PrimsPair>());
        }

        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adjList.get(u).add(new PrimsPair(v, u, w));
            adjList.get(v).add(new PrimsPair(u, v, w));
        }

        int sum=0;

        boolean[] visited=new boolean[V];

        Queue<PrimsPair> queue=new PriorityQueue<>((a, b)->{
            if(a.getWeight()!=b.getWeight()){
                return a.getWeight()-b.getWeight();
            }else{
                return a.getNode()-b.getNode();
            }
        });

        queue.offer(new PrimsPair(0, -1, 0));

        while(!queue.isEmpty()){
            PrimsPair cur=queue.poll();
            int node=cur.getNode();
            int weight=cur.getWeight();
            if(!visited[node]){
                visited[node]=true;
                sum+=weight;
                for(PrimsPair adj:adjList.get(node)){
                    int newNode=adj.getNode();
                    int newParent=adj.getParent();
                    int newWeight=adj.getWeight();
                    queue.offer(new PrimsPair(newNode, newParent, newWeight));
                }
            }
        }

        return sum;
    }

    // Disjoint Set Union
    static class DSU{
        private int[] parent;
        public DSU(int n){
            parent=new int[n+1];
            Arrays.fill(parent, -1);
        }
        public int findUPar(int node){
            if(parent[node]<0){
                return node;
            }
            // Path Compression
            parent[node]=findUPar(parent[node]);
            return parent[node];
        }
        public void union(int u, int v){
            int uUPar=findUPar(u);
            int vUPar=findUPar(v);
            if(uUPar==vUPar){
                // Both belongs to same set
                return;
            }
            if(uUPar<=vUPar){
                // uUPar set contains more elements
                parent[uUPar]+=parent[vUPar];
                parent[vUPar]=uUPar;
            }else{
                // vUPar set contains more elements
                parent[vUPar]+=parent[uUPar];
                parent[uUPar]=vUPar;
            }
        }
        public int[] getParent(){
            return parent;
        }
    }

    // Kruskal's Algorithm (Minimum-Spanning-Tree)
    static class KruskalsPair{
        int u;
        int v;
        int w;
        public KruskalsPair(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
        public int getU(){
            return u;
        }
        public int getV(){
            return v;
        }
        public int getW(){
            return w;
        }
    }
    static int kruskalsMST(int V, int[][] edges) {

        int sum=0;

        DSU ds=new DSU(V);

        Queue<KruskalsPair> queue=new PriorityQueue<>((a,b)->{
            if(a.getW()!=b.getW()){
                return a.getW()-b.getW();
            }else if(a.getU()!=b.getU()){
                return a.getU()-b.getU();
            }else{
                return a.getV()-b.getV();
            }
        });

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            queue.offer(new KruskalsPair(u, v, w));
        }

        while(!queue.isEmpty()){
            KruskalsPair cur=queue.poll();
            int u=cur.getU();
            int v=cur.getV();
            int w=cur.getW();

            int uUPar=ds.findUPar(u);
            int vUPar=ds.findUPar(v);

            if(uUPar!=vUPar){
                sum+=w;
                ds.union(u, v);
            }
        }

        return sum;

    }

}
