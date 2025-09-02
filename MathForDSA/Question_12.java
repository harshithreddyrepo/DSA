package DSA_with_kunal.MathForDSA;

public class Question_12 {
    public static void main(String[] args) {
        int a=3;
        int b=6;
        int ans=1;
        int base=a;
        while(b>0){
            if((1&b)==1){
                ans=ans*base;
            }
            base*=base;
            b>>=1;
        }
        System.out.println(ans);
        System.out.println(Math.pow(3,6));
    }
}
