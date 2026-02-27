package DSA_with_kunal.GraphDataStructureAndAlgorithms;

public class Problems {
    // Q1. Number of Provinces
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
}
