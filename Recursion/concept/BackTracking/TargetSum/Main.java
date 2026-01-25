package DSA_with_kunal.Recursion.concept.BackTracking.TargetSum;

public class Main {
    public static void main(String[] args) {

    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,0,0,target);
    }

    public static int helper(int[] nums, int exp, int i, int target){
        if(i==nums.length){
            return exp==target?1:0;
        }
        int count=0;
        count+=helper(nums,exp+nums[i],i+1,target);
        count+=helper(nums,exp-nums[i],i+1,target);
        return count;
    }
}
