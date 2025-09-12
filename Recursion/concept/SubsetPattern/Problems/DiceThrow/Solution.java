package DSA_with_kunal.Recursion.concept.SubsetPattern.Problems.DiceThrow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
          int target=4;
         System.out.println(diceCombination("",target));
    }
    public static List<String> diceCombination(String p,int target){
        List<String> list=new ArrayList<>();
        if(target<=0){
            list.add(p);
            return list;
        }
        for(int i=1;i<=6 && i<=target;i++){
            list.addAll(diceCombination(p+i,target-i));
        }
        return list;
    }
}
