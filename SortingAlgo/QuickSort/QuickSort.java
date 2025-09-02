package DSA_with_kunal.SortingAlgo.QuickSort;
import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {50,20,30,15,40,5};

        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int start=low;
        int end=high;
        int m=start+(end-start)/2;
        int pivot=arr[m];
        while(start<=end){
            while(arr[start]<pivot){
                start++;
            }
            while(arr[end]>pivot){
                end--;
            }
            if(start<=end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        quickSort(arr,low,end);
        quickSort(arr,start,high);
    }

   public static void quickSortAsce(int low,int high,int[] arr) {
        if(low<high) {
             int pivot = arr[low],i=low,j=high,temp;
             while(arr[i]<=pivot && i<high) {
                 i++;
             }
             while(arr[j]>pivot){
                 j--;
             }
             if(i<j) {
                temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                quickSortAsce(low,high,arr);
            }
            else {
                arr[low]=arr[j];
                arr[j]=pivot;
                quickSortAsce(low,j-1,arr);
                quickSortAsce(j+1,high,arr);
            }
        }
    }
    public static void quickSortDesc(int low,int high,int[] arr){

        if(low<high)
        {
            int i=low,j=high,pivot,temp;
            pivot = arr[low];
            while (arr[i]>=pivot && i<high) {
                i++;
            }
            while (arr[j] < pivot && j>=low ) {
                j--;
            }
            if(i<j) {
                temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                quickSortDesc(low,high,arr);
            }
            else {
                arr[low]=arr[j];
                arr[j]=pivot;
                quickSortDesc(low,j-1,arr);
                quickSortDesc(j+1,high,arr);
            }
        }
    }
}
