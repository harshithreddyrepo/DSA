package DSA_with_kunal.BinarySearch.Questions.Q5InfiniteSortedArray;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130,
                140, 160, 170};
        System.out.println(infiniteSearch(10,arr));
    }
    public static int infiniteSearch(int target, int[] arr) {
        int start = 0, end = 1, temp;
        while (target > arr[end]) {
            temp = end + 1;
            end = (end - start + 1) * 2;
            start = temp;
        }
        return binarySearchRange(target,start,end,arr);
    }
    public static int binarySearchRange(int target, int start, int end, int[] arr) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}