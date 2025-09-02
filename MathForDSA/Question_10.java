package DSA_with_kunal.MathForDSA;
// Find the no. of digits in the binary representation.
public class Question_10 {
    public static void main(String[] args) {
        int n=10;
        //Method-1
        int num=n;
        int i=0;
        while(n>0){
           n=n>>1;
           i++;
        }
        System.out.println("no. of digits in binary representation of "+num+" is: "+i);

        //Method-2
        // This is the general method it will work for any base value
        i=(int)(Math.log(num)/Math.log(2))+1;  //base 2
        System.out.println("no. of digits in binary representation of "+num+" is: "+i);
    }
}
