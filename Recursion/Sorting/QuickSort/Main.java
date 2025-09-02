package DSA_with_kunal.Recursion.Sorting.QuickSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums={0,0,0,0,0};
       // quickSort(nums,0,nums.length-1);
        enhancedQuickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int i=low;
        int j=high;
        int pivot=nums[low+(high-low)/2];
        while(i<=j){
            while(nums[i]<pivot){
                i++;
            }
            while(nums[j]>pivot){
                j--;
            }
            if(i<=j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
        }
        quickSort(nums,low,j);
        quickSort(nums,i,high);
    }

    public static void enhancedQuickSort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int i=low;
        int j=high;
        int pivot=low+(high-low)/2;
        while(i<=j){
            while(nums[i]<nums[pivot]  || i==pivot){
                i++;
            }
            while(nums[j]>nums[pivot]){
                j--;
            }
            if(i<=j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
            if(i>j){
                int temp=nums[i];
                nums[i]=nums[pivot];
                nums[pivot]=temp;
            }
        }
        quickSort(nums,low,j);
        quickSort(nums,i+1,high);
    }
}
