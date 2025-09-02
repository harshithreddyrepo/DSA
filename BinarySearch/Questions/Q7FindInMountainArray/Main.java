package DSA_with_kunal.BinarySearch.Questions.Q7FindInMountainArray;
interface MountainArray{
    int get(int index);
    int length();
}
class Array implements MountainArray{
    private final int[] arr={3,5,3,2,0};
    @Override
    public int get(int index) {
        return arr[index] ;
    }

    @Override
    public int length() {
        return arr.length;
    }
}

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mid = peakIndex(mountainArr);
        if(mountainArr.get(mid)<target){
            return -1;
        }
        int left=binarySearchLeft(target,0,mid,mountainArr);
        if(left!=-1)
        {
            return left;
        }else{
            return binarySearchRight(target,mid+1,mountainArr.length()-1,mountainArr);
        }

    }
        static public int binarySearchLeft(int target,int start,int end,MountainArray mountainArr){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==mountainArr.get(mid)){
                return mid;
            } else if (target>mountainArr.get(mid)) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }
        static public int binarySearchRight(int target,int start,int end,MountainArray mountainArr){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==mountainArr.get(mid)){
                return mid;
            } else if (target<mountainArr.get(mid)) {
                start =mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }
    public static int peakIndex(MountainArray mountainArr){
        int start=0,end=mountainArr.length()-1,mid = 0;
        while (start<=end){
            mid=start+(end-start)/2;
            if(mid>0 && mountainArr.get(mid)<mountainArr.get(mid-1))
            {
                end=mid-1;
            } else if (mid< mountainArr.length()-1 && mountainArr.get(mid)<mountainArr.get(mid+1)) {
                start=mid+1;
            }else {
                return mid;
            }
        }
        return mid;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findInMountainArray(0,new Array()));
    }
}
