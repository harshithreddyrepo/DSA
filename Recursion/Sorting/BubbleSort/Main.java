package DSA_with_kunal.Recursion.Sorting.BubbleSort;

import java.util.Arrays;

/*
   Pattern 1:
     * * * * *
     * * * *
     * * *
     * *
     *

 */
public class Main {
    public static void main(String[] args) {
        int[] nums={3,2,4,6,1,9};
        bubbleSort(nums,nums.length-1,0);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums,int i,int j){
        if(i==0){
           return;
        }
        if(j<i){
            if(nums[j]>nums[j+1]){
                int temp=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=temp;
            }
            bubbleSort(nums,i,j+1);
        }else {
            bubbleSort(nums,i-1,0);
        }
    }

}
