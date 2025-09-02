package DSA_with_kunal.Top150InterviewQuestions.kadanesAlgorithme.MaximunSumCircularSubArray;

public class Main {
    public static void main(String[] args) {
     int[] arr={9,-4,-7,9};
        System.out.println(maxSubarraySumCircular2(arr));
    }
    public static int maxSubarraySumCircular1(int[] nums) {
        int sum=0;
        int n=nums.length;
        int maxiSum=Integer.MIN_VALUE;
        int end=n;
        int i=0;

        while(i<end){
            if(sum==0 && i<n){
                end=i+n;
            }
            sum=sum+nums[i%n];
            if(maxiSum<sum){
                maxiSum=sum;
            }
            if(sum<0){
                sum=0;
            }
            i++;
        }
        return maxiSum;
    }

    public static int maxSubarraySumCircular2(int[] nums) {
        int maxStraightSum=Integer.MIN_VALUE,maxSum=0;
        int minStraightSum=Integer.MAX_VALUE,minSum=0;
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            maxSum+=nums[i];
            minSum+=nums[i];
            totalSum+=nums[i];

            if(maxSum>maxStraightSum){
                maxStraightSum=maxSum;
            }
            if(maxSum<0){
                maxSum=0;
            }

            if(minSum<minStraightSum){
                minStraightSum=minSum;
            }
            if(minSum>0){
                minSum=0;
            }
        }

        if(minStraightSum==totalSum){
            return maxStraightSum;
        }else{
            return Math.max(maxStraightSum, (totalSum - minStraightSum));
        }
    }
}
