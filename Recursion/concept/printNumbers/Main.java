package DSA_with_kunal.Recursion.concept.printNumbers;
// Write a function that takes a number and print all integers up to it.
// Input:5
// Output: 1 2 3 4 5
public class Main {
    public static void main(String[] args) {
        int num=5;
        printNum(num);
    }
    public static void printNum(int num){
        if(num==1){
            System.out.print(num);
        }else{
            printNum(num-1);
            System.out.print(" "+num);
        }
    }
}
