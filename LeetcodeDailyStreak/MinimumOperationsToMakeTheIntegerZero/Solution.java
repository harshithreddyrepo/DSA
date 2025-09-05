package DSA_with_kunal.LeetcodeDailyStreak.MinimumOperationsToMakeTheIntegerZero;

public class Solution {
    public static void main(String[] args) {
        int num1=3;
        int num2=-2;
        System.out.println(makeTheIntegerZero(num1,num2));
    }
    public static int makeTheIntegerZero(int num1, int num2) {
        int t=0;
        while (t<36) {
            long val = (long) num1 - (long) t * num2;
            if (val < 0) {
                return -1;
            }
            int popcount = Long.bitCount(val);
            if (t >= popcount && t <= val) {
                return t;
            }
            t++;
        }

        return -1;

    }
}
