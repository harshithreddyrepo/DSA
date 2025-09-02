package DSA_with_kunal.Recursion.Sorting.InsertionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      int[] nums={2,4,3,1,0};
      insertionSort(nums,0,0);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums,int index,int i){
        if(index==nums.length){
            return;
        }
        if(i>0){
            if(nums[i]<nums[i-1]){
                nums[i]=nums[i]+nums[i-1];
                nums[i-1]=nums[i]-nums[i-1];
                nums[i]=nums[i]-nums[i-1];
            }
            insertionSort(nums,index,i-1);
        }else{
            insertionSort(nums,index+1,index+1);
        }
    }
}
