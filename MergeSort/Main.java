package DSA_with_kunal.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
     int[] arr={5,4,3,2,1};
        mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int start,int end){
       if(end-start==1){
           return;
       }
       int mid=(start+end)/2;
       mergeSort(arr,start,mid);
       mergeSort(arr,mid,end);

       merge(arr,start,mid,end);
    }
    public static void merge(int[] arr,int start,int mid,int end){
       int[] temp=new int[end-start];
       int i=start,j=mid,k=0;
       while(i<mid && j<end){
           if(arr[i]<arr[j]){
               temp[k]=arr[i];
               i++;
           }else{
               temp[k]=arr[j];
               j++;
           }
           k++;
       }

       while(i<mid){
          temp[k]=arr[i];
          i++;
          k++;
       }

       while(j<end){
           temp[k]=arr[j];
           j++;
           k++;
       }

       for(k=0;k<temp.length;k++){
           arr[start+k]=temp[k];
       }
    }
}
