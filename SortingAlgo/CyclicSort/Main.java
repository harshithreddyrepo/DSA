package DSA_with_kunal.SortingAlgo.CyclicSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr={3,5,2,1,4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void cyclicSort(int[] arr){
        int temp;
        for(int i=0;i<arr.length;i++){
            while(arr[i]!=i+1){
                temp=arr[arr[i]-1];
                arr[arr[i]-1]=arr[i];
                arr[i]=temp;
            }
        }
    }
}
