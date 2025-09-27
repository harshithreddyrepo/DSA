package DSA_with_kunal.Recursion.concept.BackTracking.HamiltonianCycleProblem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       int[][] graph={
               {0,1,1,0,1},  // 0
               {1,0,1,1,1},  // 1
               {1,1,0,1,0},  // 2
               {0,1,1,0,1},  // 3
               {1,1,0,1,0}   // 4
       };
        int[] freq=new int[graph.length];
        freq[0]=1;
        System.out.println(getHamiltonianCycle(graph,"1-",freq,0,1));
//        System.out.println(checkHamiltonianCycle(graph,freq,0,1));
        System.out.println(countHamiltonianCycle(graph,freq,0,1));
    }

    public static List<String> getHamiltonianCycle(int[][] graph, String path, int[] freq,int row, int cnt){
        List<String> list=new ArrayList<>();
        if(cnt==graph.length){
            if(graph[row][0]==1){
                path=path+1;
                list.add(path);
                return list;
            }
        }
        for(int c=0;c<graph[row].length;c++){
            if(graph[row][c]==1) {
                if (freq[c] == 0) {
                    freq[c] += 1;
                    list.addAll(getHamiltonianCycle(graph, path + (c + 1) + "-", freq, c, cnt + 1));
                    freq[c] -= 1;
                }
            }
        }
      return list;
    }

    public static boolean checkHamiltonianCycle(int[][] graph, int[] freq, int row, int cnt){
        if(cnt==graph.length){
            return graph[row][0] == 1;
        }
        for(int c=0;c<graph[row].length;c++){
            if(graph[row][c]==1){
                if(freq[c]==0){
                    freq[c]=1;
                    if(checkHamiltonianCycle(graph,freq,c,cnt+1)){
                        return true;
                    }
                    freq[c]=0;
                }
            }
        }
        return false;
    }

    public static int countHamiltonianCycle(int[][] graph, int[] freq, int row, int cnt){
        if (cnt == graph.length) {
            return graph[row][0] == 1 ? 1 : 0;
        }
        int count=0;
        for(int c=0;c<graph.length;c++){
            if(graph[row][c]==1){
                if(freq[c]==0){
                    freq[c]=1;
                    count+=countHamiltonianCycle(graph,freq,c,cnt+1);
                    freq[c]=0;
                }
            }
        }
        return count;
    }
}
