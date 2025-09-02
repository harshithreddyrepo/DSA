package DSA_with_kunal.Top150InterviewQuestions.BinarySearch.MedianOfTowSortedArrays.OptimalApproach;

public class Main {
    public static void main(String[] args) {
        int[] arr1={1,3};
        int[] arr2={2};
        System.out.println(medianOfTowSortedArrays(arr1,arr2));
    }
    public static double medianOfTowSortedArrays(int[] nums1,int[] nums2){
        if(nums1.length>nums2.length){
            return medianOfTowSortedArrays(nums2,nums1);
        }else {
            int m=nums1.length,n=nums2.length;
            int left=(m+n+1)/2;
            int start=0,end=nums1.length;
            while(start<=end){
                int mid1=start+(end-start)/2;
                int mid2=left-mid1;
                int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
                int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
                int r1 = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;
                int r2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;
                if (l1 <= r2 && l2 <= r1) {
                    if ((m+n) % 2 == 1) return Math.max(l1, l2);
                    else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                } else if (l1 > r2) end = mid1 - 1;
                else start = mid1 + 1;
            }

        }
        return 0;
    }
}



/*
import java.util.*;

public class tUf {
    public static double median(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(nums2, nums1);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + median(a, b));
    }
}

*/

