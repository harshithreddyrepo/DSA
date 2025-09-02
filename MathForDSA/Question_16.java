package DSA_with_kunal.MathForDSA;

import static DSA_with_kunal.MathForDSA.Question_15.zeroToA_XoR;

public class Question_16 {
    public static void main(String[] args) {
        int a=3;
        int b=9;
        System.out.println(rangeXor(a,b));
    }
    public static int rangeXor(int a, int b){
        return zeroToA_XoR(b) ^ zeroToA_XoR(a-1);
    }
}
