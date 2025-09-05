package DSA_with_kunal.CRT.Questions.SumOfDigitsAtEvenOddPositions;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int num=1234567;
        System.out.println(Arrays.toString(sumAtEvenAndOddPositions(num)));
    }
    public static int[] sumAtEvenAndOddPositions(int num){
        boolean even=true;
        int evenSum=0;
        int oddSum=0;
        while (num>0){
            int rem=num%10;
            if(even){
                evenSum+=rem;
                even=false;
            }else {
                oddSum+=rem;
                even=true;
            }
            num/=10;
        }
        if(even){
           return new int[]{oddSum,evenSum};
        }
        return new int[]{evenSum,oddSum};
    }
}
