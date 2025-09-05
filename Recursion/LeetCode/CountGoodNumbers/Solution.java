package DSA_with_kunal.Recursion.LeetCode.CountGoodNumbers;

class Solution {
    public static void main(String[] args) {

    }
    static final long MOD = 1_000_000_007L;
    public int countGoodNumbers(long n) {
        return (int)helper(n,1);
    }

    public static long helper(long n,int flag){
        if(n==0){
            return 1;
        }
        flag=flag==1?0:1;
        if(flag==0){
            return (5*helper(n-1,flag))%MOD;
        }
        return (4*helper(n-1,flag))%MOD;
    }
}
