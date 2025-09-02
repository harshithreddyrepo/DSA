package DSA_with_kunal.Recursion.problems.easy.sumOfDigits;
// Write a function that takes an integer as an input and gives sum of digits as an output
public class Main {
    public static void main(String[] args) {
        int num = 246;
        System.out.println(sumOfDigits(num));

    }
    public static int sumOfDigits(int num){
        if(num<10){
            return num;
        }
        return num%10 + sumOfDigits(num/10);
    }
}
