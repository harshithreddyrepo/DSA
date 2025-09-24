package DSA_with_kunal.Recursion.concept.BackTracking.CombinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return helper(candidates, target, new ArrayList<Integer>(), 0);
    }
    public static List<List<Integer>> helper(int[] candidates, int target, List<Integer> sol, int i){
        int sum=0;
        for(int n:sol){
            sum+=n;
        }
        List<List<Integer>> list=new ArrayList<>();
        if(sum == target){
            list.add(new ArrayList<>(sol));
            return list;
        }
        if(sum>target || i==candidates.length){
            return list;
        }
        sol.add(candidates[i]);
        list.addAll(helper(candidates, target, sol, i));
        sol.remove(sol.size() - 1);
        list.addAll(helper(candidates, target, sol, i + 1));
        return list;
    }
}
