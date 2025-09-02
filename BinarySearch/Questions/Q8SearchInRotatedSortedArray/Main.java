package DSA_with_kunal.BinarySearch.Questions.Q8SearchInRotatedSortedArray;

import static DSA_with_kunal.BinarySearch.Main.binarySearch;

public class Main {
    public static void main(String[] args){
        int[] arr={5,4,4,4,1,2,2,3,3};
       // System.out.println(findPivot(arr));
        System.out.println(searchInSortedArray(4,arr));
    }
    public static int searchInSortedArray(int target,int[] arr){
        int pivot=findPivot(arr);
        int left=binarySearch(target,0,pivot,arr);
        if(left != -1)
            return left;
        else
            return binarySearch(target,pivot+1,arr.length-1,arr);
    }

    public static int findPivot(int[] arr){
        int start=0,end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
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
        return end;
    }
    static public int binarySearch(int target,int start,int end,int[] arr){
        while(start<=end){
           int mid=start+(end-start)/2;
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

    public static int rotatedBinarySearch(int nums[],int target){
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                if(nums[s]<target){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }else{
                if(nums[s]<target){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
        }
        return -1;
    }
}
