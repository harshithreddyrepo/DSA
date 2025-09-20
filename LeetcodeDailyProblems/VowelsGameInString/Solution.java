package DSA_with_kunal.LeetcodeDailyProblems.VowelsGameInString;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        String s="aezd";
        System.out.println(doesAliceWin(s));
    }
    public static boolean doesAliceWin(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : "AEIOUaeiou".toCharArray()) {
            vowels.add(c);
        }
        boolean turn=true;
        int vowelCount=0;
      while(!s.isEmpty()){
       //   int max=0;
          int count=0;
          int p=0;
          for(int i=0;i<s.length();i++){
             if(vowels.contains(s.charAt(i))){
                 count++;
                 if(turn){
                     if((count&1)==1){
                         p=i+1;
                     }
                 }else{
                     if(((count&1)==0)){
                         p=i+1;
                     }
                 }
             }

          }
          if(p==0){
              return !turn;
          }
          turn=!turn;
          s=s.substring(p);
      }
      return !turn;
    }
}
