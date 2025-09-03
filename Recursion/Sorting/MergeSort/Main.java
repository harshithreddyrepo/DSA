package DSA_with_kunal.Recursion.Sorting.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums={5,4,3,2,1};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int mid=low+(high-low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    public static void merge(int[] nums,int low,int mid,int high){
        int[] res=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=high){
            if(nums[i]<=nums[j]){
                res[k]=nums[i];
                i++;
            }else {
                res[k]=nums[j];
                j++;
            }
            k++;
        }

            while(i<=mid) {
                res[k] = nums[i];
                i++;
                k++;
            }

            while (j<=high){
                res[k]=nums[j];
                j++;
                k++;
            }
        i=low;
        for(int num:res){
            nums[i]=num;
            i++;
        }
    }
}
