package DSA_with_kunal.Recursion.concept.BackTracking.GrayCode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(grayCode(16));
    }
    public static List<Integer> grayCode(int n) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        for(int i=0;i<n;i++){
            cur.add(0);
        }
        helper(n,cur,result);
        List<Integer> seq=new ArrayList<>();
        for(List<Integer> list:result){
            int sum=0;
            for(int i=0;i<list.size();i++){
                sum=sum+list.get(i)*(int)Math.pow(2,i);
            }
            seq.add(sum);
        }
        return seq;
    }
    public static boolean helper(int n, List<Integer> cur, List<List<Integer>> result){
        if(result.size()==Math.pow(2,n)){
            return adjacentPair(result.getFirst(), result.getLast());
        }
        if(result.contains(cur)){
            return false;
        }
        result.add(cur);
        List<Integer> temp=new ArrayList<>(cur);
        for(int i=0;i<cur.size();i++){
            temp.set(i,temp.get(i)==0?1:0);
//            if(!result.contains(temp)){
//                result.add(temp);
//                if(helper(n,temp,result)){
//                    return true;
//                }
//                result.removeLast();
//            }
            if(helper(n,temp,result)){
                    return true;
                }
            temp.set(i,temp.get(i)==0?1:0);
        }
        result.removeLast();
        return false;
    }
   public static boolean adjacentPair(List<Integer> n1, List<Integer> n2){
        int dif=0;
        for(int i=0;i<n1.size();i++){
            if(n1.get(i)!=n2.get(i)){
                dif++;
            }
        }
        if(dif==1){
            return true;
        }
        return false;
    }
}