package DSA_with_kunal.SortingAlgo.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
       // selectionSort(arr);
        recursiveSelectionSort(0,arr.length-1,0,arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
        int len=arr.length,temp,max;
        for(int i=0;i<len-1;i++){
            max=0;
            for(int j=0;j<len-1-i;j++){
               if(arr[max]<arr[j+1]){
                   max=j+1;
               }
            }
            temp=arr[len-1-i];
            arr[len-1-i]=arr[max];
            arr[max]=temp;
        }
    }

    public static void recursiveSelectionSort(int max,int row,int col,int[] arr){
       if(row==0){
           return;
       }
       int temp;
       if(col<=row){
           if(arr[col]>arr[max]){
               max=col;
           }
           recursiveSelectionSort(max,row,col+1,arr);
       }else{
           temp=arr[row];
           arr[row]=arr[max];
           arr[max]=temp;
           recursiveSelectionSort(0,row-1,0,arr);
       }
    }
}
