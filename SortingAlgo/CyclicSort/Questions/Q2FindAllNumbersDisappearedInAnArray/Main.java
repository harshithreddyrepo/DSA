package DSA_with_kunal.SortingAlgo.CyclicSort.Questions.Q2FindAllNumbersDisappearedInAnArray;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
     int[] nums={};
     sort(nums);
        System.out.println(Arrays.toString(nums));
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
