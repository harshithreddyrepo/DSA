package DSA_with_kunal.Recursion.Arrays.SortedArray;
// Write a function to check whether the array is sorted or not using recursion
public class Main {
    public static void main(String[] args) {
     int nums[]={1,2,6,4,5};
        System.out.println(sortedArray(nums,0));
    }
    public static boolean sortedArray(int[] nums,int index){
        if(index==nums.length-1){
            return true;
        }
        boolean flag=nums[index]<=nums[index+1];
        return flag&&sortedArray(nums,index+1);
    }
}
