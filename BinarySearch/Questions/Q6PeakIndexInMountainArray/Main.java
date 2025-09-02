package DSA_with_kunal.BinarySearch.Questions.Q6PeakIndexInMountainArray;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,9,7,5,4,3,2,1};
        System.out.println(peakIndex(arr));
    }
    public static int peakIndex(int[] arr){
        int start=0,end=arr.length,mid = 0;
        while (start<=end){
            mid=start+(end-start)/2;
            if(arr[mid]<arr[mid-1])
            {
                end=mid-1;
            } else if (arr[mid]<arr[mid+1]) {
                start=mid+1;
            }else {
                return mid;
            }
        }
      return mid;
    }

   /*
    public int peakIndexInMountainArray(int[] arr) {
        int start=0,end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
    */
}
