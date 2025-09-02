package DSA_with_kunal.Top150InterviewQuestions.TwoPointers.MaxConsecutiveOnes3;

class Solution {
    public static void main(String[] args) {
        int nums[]={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        System.out.println(longestOnes(nums,k));
    }
    public static int longestOnes(int[] nums, int k) {
        int start=0;
        int end=0;
        int maxLen=0;
        int len=0;
        for(end=0;end<nums.length;end++){
            if(nums[end]==0){
                k--;
            }
            while(k<=0){
                if(nums[start]==0){

                    k++;
                }
               else{
                   start++;
                }
            }

        }
        return len;
    }
}