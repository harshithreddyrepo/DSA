package DSA_with_kunal.Top150InterviewQuestions.SlidingWindow.MinimumWindowSubstring;
import java.util.*;
class Solution {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        char[] str=s.toCharArray();
        int minSize=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        int r=0;
        int l=0;
        int count=0;
        Map<Character,Integer> freq=new HashMap<>();
        for(char c:t.toCharArray()){
            if(freq.containsKey(c)){
                freq.put(c,freq.get(c)+1);
            }else{
                freq.put(c,1);
            }
        }

        while(r<str.length){
            if(freq.containsKey(str[r])){
                if(freq.get(str[r])>0){

                    count++;
                }
                freq.put(str[r],freq.get(str[r])-1);
            }


            while(count==t.length()){
                if(freq.containsKey(str[l])){
                    freq.put(str[l],freq.get(str[l])+1);
                   if(freq.get(str[l])>0){
                       count--;
                   }
                }
                if((r-l+1)<minSize){
                    start=l;
                    end=r+1;
                    minSize=r-l+1;
                }
                l++;
            }
            r++;
        }
        return s.substring(start,end);
    }
}
