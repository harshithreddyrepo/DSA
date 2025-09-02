package DSA_with_kunal.SortingAlgo.CyclicSort.Questions.Q3FindTheDuplicateNumber;

public class Main {
    public static void main(String[] args) {

    }
    public static int duplicateNumber(int[] nums){
        sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return nums[i];
            }
        }
        return -1;
    }

    public static void sort(int nums[]){
        int i=0,temp;
        while(i<nums.length){
            if(nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){
                temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }else {
                i++;
            }
        }
    }
}
