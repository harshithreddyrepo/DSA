package DSA_with_kunal.Top150InterviewQuestions.BinarySearch.MinInRotatedSortedArray;

public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(minElement(nums));

    }
    public static int minElement(int[] nums){
        int start=0,end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                return mid;
            }
            if(mid<nums.length-1 && nums[mid]>nums[mid+1]){
                return mid+1;
            }
            if( nums[mid]<nums[end]){
                end=mid-1;
            }else {
                start = mid+1;
            }
        }
        return start;
    }

}
