package DSA_with_kunal.BinarySearch.Questions.Q1CeilingValue;
import DSA_with_kunal.SortingAlgo.QuickSort.QuickSort;
// ceiling number : the least value that is greater than or equal to the given number.
public class Main {
    public static void main(String[] args) {
        int[] arr={2,42,4,23,64,13,54,25,73,15,73,95,24,90,42,51,72,34,61};
        QuickSort.quickSortAsce(0,arr.length-1,arr);
        System.out.println(ceilingNumber(100,arr));
    }
    public static int ceilingNumber(int target,int[] arr){
        if(target > arr[arr.length-1]){
            return -1;
        }
        int start=0,end=arr.length-1,mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(target==arr[mid]){
                return arr[mid];
            } else if (target>arr[mid]) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
 //        if(arr[mid]>target){
 //            return arr[mid];
 //        }else {
 //            return arr[mid+1];
 //        }
        return arr[start];
    }
}
