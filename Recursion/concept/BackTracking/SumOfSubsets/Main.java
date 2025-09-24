package DSA_with_kunal.Recursion.concept.BackTracking.SumOfSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
      This problem was asked by Google.
Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.
Integers can appear more than once in the list. You may assume all numbers in the list are positive.
For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.

 */
public class Main {
    public static void main(String[] args) {
        Integer[] arr={12, 1, 6, 5, 9, 2};
        List<Integer> s = new ArrayList<>(Arrays.stream(arr).toList());
        int k=24;
        List<Integer> result=new ArrayList<>();
       // System.out.println(sumOfSubsets1(s,result,k));
        System.out.println(sumOfSubsets2(s,result,0,k));

    }

    public static List<List<Integer>> sumOfSubsets1(List<Integer> s, List<Integer> result, int k){
        int sum=0;
        for(int n:result){
            sum+=n;
        }
        List<List<Integer>> outerList=new ArrayList<>();
        if(sum==k){
           outerList.add(new ArrayList<>(result));
           return outerList;
        }
        if(sum>k || s.size()==0){
            return outerList;
        }

        result.add(s.get(0));
        outerList.addAll(sumOfSubsets1(s.subList(1,s.size()),result,k));
       // s.add(result.get(result.size()-1));
        result.remove(result.size()-1);
        outerList.addAll(sumOfSubsets1(s.subList(1,s.size()),result,k));

        return outerList;

    }

    public static List<List<Integer>> sumOfSubsets2(List<Integer> s, List<Integer> result, int sum, int k){
        List<List<Integer>> outerList=new ArrayList<>();
        if(sum==k){
            outerList.add(new ArrayList<>(result));
            return outerList;
        }
        if(sum>k || s.size()==0){
            return outerList;
        }

        result.add(s.get(0));
        outerList.addAll(sumOfSubsets2(s.subList(1,s.size()),result,sum+s.getFirst(),k));
        // s.add(result.get(result.size()-1));
        result.remove(result.size()-1);
        outerList.addAll(sumOfSubsets2(s.subList(1,s.size()),result,sum,k));

        return outerList;

    }
}
