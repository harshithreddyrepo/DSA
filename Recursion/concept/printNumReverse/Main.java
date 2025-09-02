package DSA_with_kunal.Recursion.concept.printNumReverse;
// Write a function that takes a number and print all integers up to it in reverse order.
// Input:5
// Output: 5 4 3 2 1
public class Main {
    public static void main(String[] args) {
        int num=5;
        printRevNum(num);
    }
    public static void printRevNum(int num){
        if(num==1){
            System.out.print(num);
        }else{
            System.out.print(num+" ");
            printRevNum(num-1);
        }
    }
}
