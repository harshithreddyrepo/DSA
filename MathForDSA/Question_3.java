package DSA_with_kunal.MathForDSA;
import java.util.Scanner;
public class Question_3 {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number and the ith bit required:");
        Integer num=sc.nextInt();
        int i=sc.nextInt();
        System.out.println(Integer.toBinaryString(num));
        System.out.println(ithBit(num,i));
    }
    public static int ithBit(int num,int i){
        int bit=1;
        bit<<=(i-1);
        bit=bit&num;
        bit>>=i-1;
        return bit;
    }
}
