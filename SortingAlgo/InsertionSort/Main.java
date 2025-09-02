package DSA_with_kunal.SortingAlgo.InsertionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr={4,2,3,5,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertionSort(int[] arr){
       int len=arr.length,temp;
       for(int i=0;i<len-1;i++){
           for(int j=i+1;j>0;j--){
               if(arr[j]<arr[j-1]){
                   temp=arr[j];
                   arr[j]=arr[j-1];
                   arr[j-1]=temp;
               }
               else{
                   break;
               }
           }
       }
    }
}
