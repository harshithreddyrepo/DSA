package DSA_with_kunal.LeetcodeDailyStreak.MinimumNumberOfPeopleToTeach;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int n=3;
        int[][] languages={{2},{1,3},{1,2},{3}};
        int[][] friendships={{1,4},{1,2},{3,4},{2,3}};
        System.out.println(minimumTeachings(n,languages,friendships));
    }
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> unhappyFrnds=new HashSet<>();
        for(int[] pair:friendships){
            boolean happy=false;
            for(int i=0;i<languages[pair[0]-1].length;i++){
                for(int j=0;j<languages[pair[1]-1].length;j++){
                    if(languages[pair[0]-1][i]==languages[pair[1]-1][j]){
                        happy=true;
                    }
                }
            }
            if(happy==false){
                unhappyFrnds.add(pair[0]-1);
                unhappyFrnds.add(pair[1]-1);
            }
        }
        int[] langFreq=new int[n];
        int max=0;
        for(int people:unhappyFrnds){
            for(int i:languages[people]){
                langFreq[i - 1]++;
                max = Math.max(max, langFreq[i - 1]);
            }
        }
        return unhappyFrnds.size()-max;
    }
}
