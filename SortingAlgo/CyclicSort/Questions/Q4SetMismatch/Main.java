package DSA_with_kunal.SortingAlgo.CyclicSort.Questions.Q4SetMismatch;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
      int[] nums={1,2,3,4,6,6};
        System.out.println(Arrays.toString(misMatch(nums)));
    }
    public static int[] misMatch(int[] nums){
        sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return new int[]{nums[i],i+1};
            }
        }
        return new int[]{-1,-1};
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
