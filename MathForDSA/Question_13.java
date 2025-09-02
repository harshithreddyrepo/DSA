package DSA_with_kunal.MathForDSA;

public class Question_13 {
    public static void main(String[] args) {
        int num=123;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(setBitNo(num));
    }
    public static int setBitNo(int n){
        int count=0;
        while(n>0){
            //Method-1
            n=n&(~(n&(-n)));

            //Method-2
            // n=n-(n&(-n));

            //Method-3
            // n=n&(n-1);

            count+=1;
        }
        return count;
    }
}
