package DSA_with_kunal.MathForDSA;

import java.util.Arrays;

public class Question_9 {
    public static void main(String[] args) {
        // Method-1
        System.out.println(nthMagicNumber(5));

        // Method-2
        int n=5;
        int base=5;
        int val=0;
        while(n>0){
            val=val+base*(n&1);
            n=n>>1;
            base=base*5;
        }
        System.out.println(val);
    }
    public static int nthMagicNumber(int n){
        int result=0;
        String binStr = Integer.toBinaryString(n);
        int[] binArr = new int[binStr.length()];
        for(int i=0;i<binStr.length();i++){
           binArr[i] = binStr.charAt(i)-'0';
           result+=(int)Math.pow(5,i+1)*binArr[i];
        }
        System.out.println(Arrays.toString(binArr));
        return result;
    }
}
