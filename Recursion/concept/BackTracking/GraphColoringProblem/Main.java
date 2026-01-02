package DSA_with_kunal.Recursion.concept.BackTracking.GraphColoringProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] graph={
                { 0, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 0, 0},
                { 0, 0, 1, 0, 0}
        };
        String[] colorPallet=new String[5];
        String[] colors={"Red","Green","Blue"};
        System.out.println(graphColoring(graph,colors,colorPallet,0));

//        int[] colorPallet=new int[5];
//        Arrays.fill(colorPallet, -1);
//        int colors=3;
//        System.out.println(mColoringDecision(graph,colorPallet,colors,0));
    }
    public static List<List<String>> graphColoring(int[][] graph, String[] colors, String[] colorPallet, int i){
        List<List<String>> outerList=new ArrayList<>();
        if(i==graph.length){
            List<String> innerList = new ArrayList<>(Arrays.asList(colorPallet));
            outerList.add(innerList);
            return outerList;
        }

        for(String color:colors){
            if(checkValidColor(graph,colorPallet,color,i)){
                colorPallet[i]=color;
                outerList.addAll(graphColoring(graph,colors,colorPallet,i+1));
                colorPallet[i]=null;
            }
        }

        return outerList;
    }
    public static boolean checkValidColor(int[][] graph, String[] colorPallet, String color, int i){
        for(int c=0;c<graph.length;c++){
            if(graph[i][c]==1){
                if(color.equals(colorPallet[c])){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean mColoringDecision(int[][] graph, int[] colorPalette, int colors, int i){
        if(i==graph.length){
            return true;
        }
        for(int j=0;j<colors;j++){
            if(isSafeToColor(graph,colorPalette,j,i)){
                colorPalette[i]=j;
                if(mColoringDecision(graph,colorPalette,colors,i+1)){
                    return true;
                }
                colorPalette[i]=-1;
            }
        }
        return false;
    }

    public static boolean isSafeToColor(int[][] graph, int[] colorPalette, int color, int i){
        for(int c=0;c<graph.length;c++){
            if(graph[i][c]==1){
                if(colorPalette[c]==color){
                    return false;
                }
            }
        }
        return true;
    }
}
