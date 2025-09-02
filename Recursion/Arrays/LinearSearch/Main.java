package DSA_with_kunal.Recursion.Arrays.LinearSearch;

public class Main {
    public static void main(String[] args) {
        int[] nums={5,3,4,10,7};
        int target=11;
        System.out.println(linearSearch(nums,0,target));
    }

    public static int linearSearch(int[] nums,int index, int target){
        if(index==nums.length-1){
            if(nums[index]==target){
                return index;
            }else{
                return -1;
            }
        }
        if(nums[index]==target)
            return index;
        return linearSearch(nums,index+1,target);
    }

}
