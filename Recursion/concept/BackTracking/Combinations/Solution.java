package DSA_with_kunal.Recursion.concept.BackTracking.Combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        return helper(n,k,list);
    }
    public static List<List<Integer>> helper(int n, int k, ArrayList<Integer> p){
        List<List<Integer>> outerList=new ArrayList<>();
        if(p.get(p.size()-1)>n){
            return outerList;
        }
        if(p.size()==k){
            List<Integer> innerList=new ArrayList<>(p);
            outerList.add(innerList);
            p.set(k-1,p.get(k-1)+1);
            outerList.addAll(helper(n,k,p));
            return outerList;
        }
        p.add(p.getLast()+1);
        outerList.addAll(helper(n,k,p));
        p.removeLast();
        p.set(p.size()-1,p.getLast()+1);
        outerList.addAll(helper(n,k,p));
        return outerList;
    }
}
