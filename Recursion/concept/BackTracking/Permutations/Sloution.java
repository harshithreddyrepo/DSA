package DSA_with_kunal.Recursion.concept.BackTracking.Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        Solution sol=new Solution();
        sol.permute(nums);
        System.out.println(sol.result);
    }
    private  List<List<Integer>> result=new ArrayList<>();
    private boolean[] check;
    public List<List<Integer>> permute(int[] nums) {
        check=new boolean[nums.length];
        helper(nums,new ArrayList<Integer>());
        return result;
    }

    public void helper(int[] nums, List<Integer> current){
        if(current.size()==nums.length){
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(check[i]){
                continue;
            }
            check[i]=true;
            current.add(nums[i]);
            helper(nums,current);
            current.remove(current.size()-1);
            check[i]=false;
        }
    }

}
