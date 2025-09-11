package DSA_with_kunal.Recursion.concept.SubsetPattern.Problems.LetterCombinationOfPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
   static HashMap<Character,String> buttonMap=new HashMap<>();
    public static void main(String[] args) {
        String digits="23";
        buttonMap.put('2',"abc");
        buttonMap.put('3',"def");
        buttonMap.put('4',"ghi");
        buttonMap.put('5',"jkl");
        buttonMap.put('6',"mno");
        buttonMap.put('7',"pqrs");
        buttonMap.put('8',"tuv");
        buttonMap.put('9',"wxyz");
        System.out.println(letterCombinations("",digits,0));
    }

    public static List<String> letterCombinations(String p,String digits,int i){
        List<String> list=new ArrayList<>();
        if(i==digits.length()){
             list.add(p);
             return list;
        }
        String up=buttonMap.get(digits.charAt(i));
        for(int k=0;k<up.length();k++){
            char c=up.charAt(k);
            list.addAll(letterCombinations(p+c,digits,i+1));
        }
        return list;
    }
}
