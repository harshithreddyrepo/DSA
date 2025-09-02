package DSA_with_kunal.BinarySearch.Questions.SplitArrayLargestSum;

public class Main {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        System.out.println(splitArrayLargestSum(arr, 2));
    }
    public static int splitArrayLargestSum(int[] nums,int k){
        int end=sumOfElements(nums);
        int start=max(nums);
        while(start<end){
            int mid=start+(end-start)/2;
            int partitions=1,sum=0;
            for(int i=0;i<nums.length;i++){
               sum+=nums[i];
               if(sum>mid){
                   partitions++;
                   sum=nums[i];
               }
            }
            if(partitions>k){
                start=mid+1;
            }
            if(partitions<=k){
                end=mid;
            }
        }
        return end;
    }
    public static int sumOfElements(int[] arr){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }
    public static int max(int[] arr){
        int max=0;
        for(int i:arr){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
}