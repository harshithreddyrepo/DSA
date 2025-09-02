package DSA_with_kunal.BinarySearch.Questions.Q4First_and_last_position_of_an_element;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(positionOfElement1(10, arr)));
        System.out.println(Arrays.toString(positionOfElement2(10, arr)));
    }

    public static int[] positionOfElement1(int target, int[] arr) {
        int start = 0, end = arr.length - 1, mid, first, last;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                first = last = mid;
                while (first > 0 && arr[mid] == arr[first - 1]) {
                    --first;
                }
                while (last < arr.length - 1 && arr[mid] == arr[last + 1]) {
                    ++last;
                }
                return new int[]{first, last};
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
public static int[] positionOfElement2(int target, int[] arr){
    int start=0,end=arr.length-1,mid;
    while(start<=end){
        mid=start+(end-start)/2;
        if(target==arr[mid]){
            int first =firstPosition(target,mid,arr);
            int last =lastPosition(target,mid, arr);
            return new int[]{first,last};
//           return new int[]{firstPosition(target,mid,arr),lastPosition(target,mid, arr)};
        } else if (target>arr[mid]) {
            start=mid+1;
        }else {
            end=mid-1;
        }
    }
        return new int[]{-1,-1};
}
public static int firstPosition(int target,int mid,int[] arr){
       int start=0,end=mid;
       while (start<=end){
           mid=start+(end-start)/2;
           if(arr[mid]==target){
               end=mid-1;
           }
           else {
               start=mid+1;
           }
       }
       return start;
}
public static int lastPosition(int target,int mid,int[] arr){
        int start=mid,end=arr.length-1;
          while (start<=end){
              mid=start+(end-start)/2;
              if(arr[mid]==target){
                  start=mid+1;
              }
               else {
                   end=mid-1;
               }
            }
          return end;
          }
}