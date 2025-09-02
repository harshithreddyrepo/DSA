package DSA_with_kunal.BinarySearch;
import DSA_with_kunal.SortingAlgo.QuickSort.QuickSort;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        QuickSort.quickSortAsce(0,arr.length-1,arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearchRecursive(50,0,arr.length-1,arr));
        System.out.println(binarySearch(30,arr));
        QuickSort.quickSortDesc(0,arr.length-1,arr);
        System.out.println(OrderAgnosticBinarySearch(30,arr));
    }
    static int binarySearchRecursive(int target,int low,int high,int[] arr) {
        if(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target){
                return mid;
            }
            else{
                if(target<arr[mid]) {
                    return binarySearchRecursive(target, low, mid - 1, arr);
                }
                else {
                   return binarySearchRecursive(target, mid + 1, high, arr);
                }
            }
        }
        return -1;
    }

    static public int binarySearch(int target,int[] arr){
            int start=0,end=arr.length-1,mid;
            while(start<=end){
                mid=start+(end-start)/2;
                if(target==arr[mid]){
                    return mid;
                } else if (target>arr[mid]) {
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
            return -1;
    }
    public static int OrderAgnosticBinarySearch(int target,int[] arr){
        if(arr.length==0){
            return 0;
        } else if (arr[0]==arr[arr.length-1] && target == arr[0]) {
            return 0;
        } else {
            if(arr[0]>arr[arr.length-1]){     // DESCENDING ORDER
                int start=0,end=arr.length-1,mid;
                while(start<=end){
                    mid=start+(end-start)/2;
                    if(target==arr[mid]){
                        return mid;
                    }
                    else if (target>arr[mid]) {
                        end=mid-1;
                    }
                    else {
                        start=mid+1;
                    }
                }
            }
            else {  // ASCENDING ORDER
                int start=0,end=arr.length-1,mid;
                while(start<=end){
                    mid=start+(end-start)/2;
                    if(target==arr[mid]){
                        return mid;
                    }
                    else if (target>arr[mid]) {
                        start=mid+1;
                    }
                    else {
                        end=mid-1;
                    }
                }
            }
        }
        return -1;
    }
}
