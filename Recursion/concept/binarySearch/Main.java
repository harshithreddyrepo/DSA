package DSA_with_kunal.Recursion.concept.binarySearch;

public class Main {
    public static void main(String[] args) {
        int[] nums ={1,3,4,7,9,11};
        int x=11;
        System.out.println(binarySearch(nums,0,nums.length-1,x));
    }
    public static int binarySearch(int[] nums,int s, int e,int x){
        if(s>e){
            return -1;
        }else{
            int mid=s+(e-s)/2;
            if(nums[mid]==x){
                return mid;
            }else if(nums[mid]>x){
                return binarySearch(nums,s,mid-1,x);
            }else{
                return binarySearch(nums,mid+1,e,x);
            }
        }
    }
}
