package DSA_with_kunal.Questions.SmallestAndLargestDigit;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int num=83190;
        System.out.println(Arrays.toString(smallestAndLargest(num)));
    }
    public static int[] smallestAndLargest(int num){
        int small=Integer.MAX_VALUE;
        int large=Integer.MIN_VALUE;
        while (num>0){
           int rem=num%10;
           small=Math.min(small,rem);
           large=Math.max(large,rem);
           num/=10;
        }

        return new int[]{small,large};
    }
}
