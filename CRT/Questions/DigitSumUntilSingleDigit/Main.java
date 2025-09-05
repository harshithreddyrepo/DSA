package DSA_with_kunal.CRT.Questions.DigitSumUntilSingleDigit;

public class Main {
    public static void main(String[] args) {
        int num=9875;
        System.out.println(digitSumUntilSingleDigit(num));
    }

    public static int digitSumUntilSingleDigit(int num){
        if(num/10==0){
            return num;
        }
        int sum=0;
        while(num>0){
           int rem=num%10;
           sum=sum+rem;
           num/=10;
        }
       return digitSumUntilSingleDigit(sum);
    }
}
