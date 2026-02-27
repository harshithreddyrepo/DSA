package DSA_with_kunal.GraphDataStructureAndAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}
