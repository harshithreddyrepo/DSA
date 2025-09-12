package DSA_with_kunal.Recursion.concept.SubsetPattern.Problems.NoOfDiceRollsWithTargetSum;
class Solution {
    static final int M=1000000007;

    public static void main(String[] args) {
        int n=3;
        int k=6;
        int target=4;
        System.out.println(numRollsToTarget(n,k,target));
    }
    // Pure recursion approach (not suitable for large input)
    public static int numRollsToTarget(int n,int k,int target){
        if(n<=0){
            if(target==0){
                return 1;
            }else{
                return 0;
            }
        }
        int count=0;
        for(int i=1;i<=k;i++){
            count=(count+numRollsToTarget(n-1,k,target-i))%M;
        }
        return count;
    }
}
