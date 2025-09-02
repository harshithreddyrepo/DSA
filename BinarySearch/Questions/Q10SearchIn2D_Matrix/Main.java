package DSA_with_kunal.BinarySearch.Questions.Q10SearchIn2D_Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       int[][] arr={
               {5,6,7,8},
               {9,10,11,12},
               {13,14,15,16}
       };
        System.out.println(Arrays.toString(searchIn2DRowAndColumnWiseSortedArray(arr,15)));
        System.out.println(Arrays.toString(binarySearchIn2D_SortedArray(arr,15)));
    }
    public static int[] searchIn2DRowAndColumnWiseSortedArray(int[][] arr,int target){
       int up=arr[0].length-1,lb=0;
       while(lb<arr.length && up>=0){
           if(target==arr[lb][up]){
               return new int[] {lb,up};
           }
           if(arr[lb][up]>target){
               up--;
           }else {
               lb++;
           }
       }
       return new int[]{-1,-1};
    }

    public static int[] binarySearchIn2D_SortedArray(int[][] arr,int target){
        int m=arr.length,n=arr[0].length,start=0,end=m*n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid/n][mid%n]==target){
                return new int[]{mid/n,mid%n};
            }
            if(arr[mid/m][mid%n]>target){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

}
