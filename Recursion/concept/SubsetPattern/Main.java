package DSA_with_kunal.Recursion.concept.SubsetPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      String s="ABC";
//        int[] num={1,2,3};
//        System.out.println(subSeqReturn("",s));
//        System.out.println(subSeqAsciiRet("",s));
//        System.out.println(iterativeSubSet(num));
        System.out.println(permutation("",s));
        System.out.println(noOfArrangements("",s));
    }
    public static List<String> subSeqReturn(String p, String up){
        List<String> list=new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        list.addAll(subSeqReturn(p,up.substring(1)));
        list.addAll(subSeqReturn(p+ch,up.substring(1)));
        return list;
    }

    public static List<String> subSeqAsciiRet(String p,String up){
        List<String> list=new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        list.addAll(subSeqAsciiRet(p,up.substring(1)));
        list.addAll(subSeqAsciiRet(p+ch,up.substring(1)));
        list.addAll(subSeqAsciiRet(p+(0+ch),up.substring(1)));
        return list;
    }

    public static List<List<Integer>> iterativeSubSet(int[] num){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i:num){
            int n=outer.size();
            for(int j=0;j<n;j++){
                List<Integer> internal=new ArrayList<>(outer.get(j));
                internal.add(i);
                outer.add(internal);
            }
           // outer.addAll(copy);
        }
        return outer;
    }

    public static List<String> permutation(String p,String up){
        List<String> list=new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        int len=p.length();
//        for(int i=0;i<=len;i++){          ==> AB/C => CAB/ACB/ABC
//            String first=p.substring(0,i);
//            String second=p.substring(i,len);
//            list.addAll(permutation(first+ch+second,up.substring(1)));
//        }
        for(int i=len;i>=0;i--){  //==> AB/C => ABC/ACB/CAB
            String first=p.substring(0,i);
            String second=p.substring(i,len);
            list.addAll(permutation(first+ch+second,up.substring(1)));
        }
        return list;
    }

    public static int noOfArrangements(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        int len=p.length();
        char ch=up.charAt(0);
        for(int i=0;i<=len;i++){
            String first=p.substring(0,i);
            String second=p.substring(i,len);
            count+=noOfArrangements(first+ch+second,up.substring(1));
        }
        return count;
    }
}
