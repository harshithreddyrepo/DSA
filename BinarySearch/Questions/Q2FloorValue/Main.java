package DSA_with_kunal.BinarySearch.Questions.Q2FloorValue;
import DSA_with_kunal.SortingAlgo.QuickSort.QuickSort;
// Floor number : the greatest value that is smaller than or equal to the given number.
public class Main {
    public static void main(String[] args) {
        int[] arr={2,42,4,23,64,13,54,25,73,15,73,95,24,90,42,51,72,34,61};
        QuickSort.quickSortAsce(0,arr.length-1,arr);
        System.out.println(ceilingNumber(40 ,arr));
    }
    public static int ceilingNumber(int target,int[] arr){
        if(target<arr[0]){
            return -1;
        }
        int start=0,end=arr.length-1,mid;
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
        //        if(arr[mid]<target){
        //            return arr[mid];
        //        }else {
        //            return arr[mid-1];
        //        }
        return arr[end];
    }
}

