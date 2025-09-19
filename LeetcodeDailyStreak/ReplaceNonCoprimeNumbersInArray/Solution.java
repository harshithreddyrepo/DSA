package DSA_with_kunal.LeetcodeDailyStreak.ReplaceNonCoprimeNumbersInArray;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public static void main(String[] args) {
        System.out.println(checkNonCoPrime(5,6));
        int[] nums={6,4,3,2,7,6,2};
        System.out.println(replaceNonCoprimes(nums));
        System.out.println(checkNonCoPrime(2009,899));
    }
    public static List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> finalArr1=new ArrayList<>();
        List<Integer> finalArr2=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(checkNonCoPrime(nums[i],nums[i+1])) {
                nums[i+1]=findLCM(nums[i],nums[i+1]);
            }else{
                finalArr1.add(nums[i]);
            }
        }
        finalArr1.add(nums[nums.length-1]);


        return finalArr1;
    }

    public static boolean checkNonCoPrime(int n1, int n2){
        while(n2 != 0){
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1 != 1;
    }

    public static int findLCM(int num1,int num2){
        int n1=num1;
        int n2=num2;
        int n1Mul=1;
        int n2Mul=1;
        while(n1!=n2){
            if(n1<n2){
                n1=num1*(++n1Mul);
            }else{
                n2=num2*(++n2Mul);
            }
        }

        return n1;
    }
}
