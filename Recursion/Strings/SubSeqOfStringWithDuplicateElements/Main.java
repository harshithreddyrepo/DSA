package DSA_with_kunal.Recursion.Strings.SubSeqOfStringWithDuplicateElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s="122";
        System.out.println(subSeq(s));
    }
    public static List<String> subSeq(String s){
        List<String> list=new ArrayList<>();
        int[] hash=new int[256];
        list.add("");
        char[] arr=s.toCharArray();
        for(char ch:arr){
            int j=0;
            int n=list.size();
            if(hash[ch]!=0){
                j=n/2;
            }
            hash[ch]++;
            for(;j<n;j++){
                list.add(new String(list.get(j)+ch));
            }
        }
        return list;
    }
}
