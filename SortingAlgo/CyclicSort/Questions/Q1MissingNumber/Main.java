package DSA_with_kunal.SortingAlgo.CyclicSort.Questions.Q1MissingNumber;

//Given an array nums containing n distinct numbers in the range [0, n],return
// the only number in the range that is missing from the array.
public class Main {
    public static void main(String[] args) {
        int[] nums={2,0,5,1,4};
        System.out.println(missingNumber(nums));
    }
    /*
    public static int missingNumber(int[] nums){
        int i=0,j=nums.length,temp,count=0;
       while(i<j){
           if(nums[i]!=i){
                 if(nums[i]==j){
                   temp=nums[j-1];
                  nums[j-1]=nums[i];
                  nums[i]=temp;
                  j--;
               }else{
                     temp=nums[nums[i]];
                     nums[nums[i]]=nums[i];
                     nums[i]=temp;
                     count++;
               }
               if(count>nums.length){
                   return i;
               }
           }else{
               i++;
               count=0;
           }
       }
       return j;
    }
     */

    public static int missingNumber(int[] nums){
        sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }
    public static void sort(int[] nums){
        int  i=0,temp;
        while(i<nums.length){
            if(nums[i]!=i && nums[i]!=nums.length){
                temp=nums[nums[i]];
                nums[nums[i]]=nums[i];
                nums[i]=temp;
            }
            else {
                i++;
            }
        }
    }


}
