package DSA_with_kunal.SortingAlgo.CyclicSort.Questions.Q5FirstMissingPositive;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums){
        sorting(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public static void sorting(int[] nums){
        int temp,i=0;
        while(i<nums.length){
            if(nums[i]!=i+1){
                if(0<nums[i]&&nums[i]<=nums.length){
                    if(nums[nums[i]-1]!=nums[i]){
                        temp=nums[nums[i]-1];
                        nums[nums[i]-1]=nums[i];
                        nums[i]=temp;
                    }
                    else{
                        i++;
                    }
                }
                else {
                    i++;
                }
            }else{
                i++;
            }
        }
    }
}
