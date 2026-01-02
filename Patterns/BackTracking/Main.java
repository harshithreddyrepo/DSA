package DSA_with_kunal.Patterns.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
    /*
    Q1. Subsets II
    =>Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
      The solution set must not contain duplicate subsets. Return the solution in any order.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return helper(new ArrayList<Integer>(), nums, 0);
    }
    private List<List<Integer>> helper(List<Integer> p, int[] up, int ptr){
        List<List<Integer>> result=new ArrayList<>();
        if(ptr==up.length){
            result.add(new ArrayList<Integer>(p));
            return result;
        }
        p.add(up[ptr]);
        result.addAll(helper(p,up,ptr+1)); // Yes
        p.remove(p.size()-1);
        if(ptr==0 || p.size()==0 || p.getLast()!=up[ptr]){
            result.addAll(helper(p, up, ptr+1));
        }
        return result;
    }
    private void mergeSort(int[] nums, int start, int end){
        if(end-start<=1){  // size 0 already sorted and size 1 is also already sorted!
            return;
        }
        int mid=start+(end-start)/2;
        mergeSort(nums, start,mid);
        mergeSort(nums, mid, end);
        merge(nums, start, end);
    }
    private void merge(int[] nums, int s, int e){
        int m=s+(e-s)/2;
        int[] arr=new int[e-s];
        int k=0;
        int i=s;
        int j=m;
        while(i<m && j<e){
            if(nums[i]<nums[j]){
                arr[k]=nums[i];
                i++;
            }else{
                arr[k]=nums[j];
                j++;
            }
            k++;
        }
        if(i<m){
            while(i<m){
                arr[k]=nums[i];
                k++;
                i++;
            }
        }else{
            while(j<e){
                arr[k]=nums[j];
                k++;
                j++;
            }
        }
        for(i=0;i<k;i++){
            nums[s+i]=arr[i];
        }
    }
    /*
    Q2. Permutations II
    =>Given a collection of numbers, nums, that might contain duplicates,
      return all possible unique permutations in any order.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1); // To store the frequency of integers
        }
        return helper(new ArrayList<Integer>(), map, nums.length);
    }
    private List<List<Integer>> helper(List<Integer> processed, Map<Integer, Integer> unProcessed, int len){
        List<List<Integer>> result=new ArrayList<>();
        if(processed.size()==len){
            result.add(new ArrayList<Integer>(processed));
            return result;
        }
        for (Map.Entry<Integer, Integer> entry :  unProcessed.entrySet()) {
            if(entry.getValue()>0){
                unProcessed.put(entry.getKey(), entry.getValue()-1);
                processed.add(entry.getKey());
                result.addAll(helper(processed, unProcessed, len));
                processed.remove(processed.size()-1);
                unProcessed.put(entry.getKey(), entry.getValue()+1);
            }
        }
        return result;
    }
}

