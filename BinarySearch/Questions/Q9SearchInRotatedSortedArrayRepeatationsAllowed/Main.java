package DSA_with_kunal.BinarySearch.Questions.Q9SearchInRotatedSortedArrayRepeatationsAllowed;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,3};
        System.out.println(findMin(nums));

    }
    public static boolean search(int[] arr,int target){
        int pivot=findPivot(arr);
        if(target>=arr[0]){
            return binarySearch(target,0,pivot,arr);
        }else {
            return binarySearch(target,pivot+1,arr.length-1,arr);
        }
    }
    public static int findPivot(int[] arr) {
        int start = 0, end = arr.length - 1,mid=0;
        while (start <= end) {
             mid = start + (end - start) / 2;
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if (start<arr.length-1 && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if (end>0  && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else {
                if(mid>0 && arr[mid]<arr[mid-1]){
                    return mid-1;
                }
                if(mid<arr.length-1 && arr[mid]>arr[mid+1]){
                    return mid;
                }
                if(arr[start]>arr[mid]){
                    end=mid-1;
                }else {
                    start=mid+1;
                }

            }
        }
        return mid;
    }


    static public boolean binarySearch(int target,int start,int end,int[] arr){

        while(start<=end){
          int  mid=start+(end-start)/2;
            if(target==arr[mid]){
                return true;
            } else if (target>arr[mid]) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return false;
    }

    public static int findMin(int[] nums){
       int s=0;
       int e=nums.length-1;
       while(s<e){
           int mid=s+(e-s)/2;
           if(nums[mid]==nums[s] && nums[mid]==nums[e]){
               if(e>0&&nums[e]<nums[e-1]){
                   return nums[e];
               }
               s=mid+1;
           }else{
               if((mid>0)&&nums[mid]<nums[mid-1]){
                   return nums[mid];
               }
               if((mid<nums.length-1)&&nums[mid]>nums[mid+1]){
                   return nums[mid+1];
               }
               if(nums[mid]<=nums[e]){
                   e=mid-1;
               }else {
                   s=mid+1;
               }
           }
       }
       return nums[s];
    }
}


