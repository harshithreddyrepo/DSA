package DSA_with_kunal.Top150InterviewQuestions.BinarySearch.MedianOfTowSortedArrays.NaiveApproach;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
     int[] arr1={1,3,7,9,12,15};
     int[] arr2={2,4,8,11,16};
        System.out.println(medianOfTowSortedArrays(arr1,arr2));
    }

    public static int medianOfTowSortedArrays(int[] arr1,int[] arr2){
        int[] arr3 = mergeTowSortedArrays(arr1,arr2);
        System.out.println(Arrays.toString(arr3));
        return median(arr3);
    }

    public static int[] mergeTowSortedArrays(int[] arr1,int[] arr2){
        int m=arr1.length;
        int n=arr2.length;
        int i=0,j=0,k=0;
        int[] arr3=new int[m+n];
        while(i<m && j<n){
            if(arr1[i]<=arr2[j]){
                arr3[k]=arr1[i];
                k++;
                i++;
            }else{
                arr3[k]=arr2[j];
                k++;
                j++;
            }
        }
        while(i<m){
            arr3[k]=arr1[i];
            i++;
            j++;
        }
        while(j<n){
            arr3[k]=arr2[j];
            j++;
            k++;
        }
        return arr3;
    }

    public static int median(int[] arr){
        int mid=arr.length/2;
        if(arr.length%2==1) {
          return arr[mid];
        }else {
            return (arr[mid]+arr[mid+1])/2;
        }
    }
}

