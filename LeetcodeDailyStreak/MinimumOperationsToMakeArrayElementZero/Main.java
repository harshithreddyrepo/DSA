package DSA_with_kunal.LeetcodeDailyStreak.MinimumOperationsToMakeArrayElementZero;

public class Main {
    public static void main(String[] args) {
        int[][] quaries={{1,2},{2,4}};
        long minOperations=0;
        for(int[] nums:quaries){
           minOperations+=operationsRequired(nums[0],nums[1]);
        }
          System.out.println(minOperations);
    }

    public static long operationsRequired(long l,long r){
        long sum=0;
        long count=1;
        long val=1;
        while(val<=r){
           long preVal=val;
           val=val<<2;
           if(l<=val){
               if(r>val-1){
                   sum+=(val-l)*count;
               }else{
                   sum+=(r-l+1)*count;
               }
               l=val;
           }
           count++;
        }
        return (sum+1)/2;
    }
}
