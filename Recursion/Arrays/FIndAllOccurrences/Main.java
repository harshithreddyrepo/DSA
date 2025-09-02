package DSA_with_kunal.Recursion.Arrays.FIndAllOccurrences;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      Integer[] nums={2,6,1,7,6,8,4,6};
      List<Integer> list=new ArrayList<>();
        System.out.println(findAllOccurrences(nums,0,6));
    }
    public static <T> List<Integer> findAllOccurrences(T[] nums,int index,T target,List<Integer> list){
        if(index==nums.length){
            return list;
        }
        if(nums[index]==target)
            list.add(index);
       return findAllOccurrences(nums,index+1,target,list);
    }
    public static <T> List<Integer> findAllOccurrences(T[] nums,int index,T target){
        ArrayList<Integer> list=new ArrayList<>();
        if(index==nums.length){
            return list;
        }

        if(nums[index]==target)
            list.add(index);
        list.addAll(findAllOccurrences(nums,index+1,target));
        return list;
    }
}
