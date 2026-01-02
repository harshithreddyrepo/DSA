package DSA_with_kunal.Patterns.DynamicProgramming;

public class Main {
    public static void main(String[] args) {

    }
    /*
    Q1. Number of Dice Rolls With Target Sum
    =>You have n dice, and each dice has k faces numbered from 1 to k.

      Given three integers n, k, and target, return the number of possible ways (out of the kn total ways)
      to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large,
      return it modulo 109 + 7.
     */
    Integer[][] dp;
    static final int M = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        dp=new Integer[n+1][target+1];
        return helper(n, k, target);
    }
    private int helper(int n, int k, int target){
        if(target<0){
            return 0;
        }
        if(n==0){
            return target==0?1:0;
        }
        if(dp[n][target]!=null){
            return dp[n][target];
        }
        int count=0;
        for(int i=1;i<=k;i++){
            count=(count+helper(n-1, k, target-i))%M;
        }
        dp[n][target]=count;
        return count;
    }
}
