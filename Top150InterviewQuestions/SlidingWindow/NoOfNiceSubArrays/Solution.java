package DSA_with_kunal.Top150InterviewQuestions.SlidingWindow.NoOfNiceSubArrays;

class Solution {
    public static void main(String[] args) {
        int[] nums={1,1,2,1,1};
        int k=3;
        System.out.println(numberOfSubarrays(nums,k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int count1=count(nums,k);
        int count2=count(nums,k-1);
        return count1-count2;
    }

    public static int count(int[] nums, int k){
        if(k<0){
            return 0;
        }
        int l=0;
        int r=0;
        int count=0;
        int freq=0;
        while(r<nums.length){
            if((nums[r]&1)==1){
                freq++;
            }
            while(freq>k){
                if((nums[l]&1)==1){
                    freq--;
                }
                l++;
            }

            count=count+(r-l+1);
            r++;
        }

        return count;
    }
}
