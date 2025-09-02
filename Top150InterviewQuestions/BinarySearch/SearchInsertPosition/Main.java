package DSA_with_kunal.Top150InterviewQuestions.BinarySearch.SearchInsertPosition;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(insertPosition(nums, 4));
    }

    public static int insertPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid]==target){
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
