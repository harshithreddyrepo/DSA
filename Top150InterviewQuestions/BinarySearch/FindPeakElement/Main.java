package DSA_with_kunal.Top150InterviewQuestions.BinarySearch.FindPeakElement;

public class Main {
    public static void main(String[] args) {
      int[] nums={1,2,3};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
