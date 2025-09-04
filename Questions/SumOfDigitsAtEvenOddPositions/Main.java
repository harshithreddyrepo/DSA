package CRT.Sept4th.Questions.SumOfDigitsAtEvenOddPositions;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int num=123456;
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
           return new int[]{evenSum,oddSum};
        }
        return new int[]{oddSum,evenSum};

    }
}
