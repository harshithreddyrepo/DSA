package DSA_with_kunal.Recursion.Sorting.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       int[] nums={2,1,6,8,3,2,6};
       selectionSort(nums,nums.length-1,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void selectionSort(int[] nums,int i,int j,int max){
        if(i==0){
            return;
        }
        if(j<i){
            if(nums[j]>nums[max]){
                max=j;
            }
            selectionSort(nums,i,j+1,max);
        }else {
            if(i!=max){
                int temp=nums[max];
                nums[max]=nums[i];
                nums[i]=temp;
            }
            selectionSort(nums,i-1,0,i-1);
        }
    }
}
