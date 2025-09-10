package DSA_with_kunal.Recursion.problems.easy.fibonacciSeries;

public class Main {
    public static void main(String[] args) {
      int num=10;
        System.out.println(fibonacci(num));
    }
    public static int fibonacci(int num){
        if(num==0 || num==1){
            return num;
        }
        return fibonacci(num-1)+fibonacci(num-2);
    }
}
