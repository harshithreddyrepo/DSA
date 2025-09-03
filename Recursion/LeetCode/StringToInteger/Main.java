package DSA_with_kunal.Recursion.LeetCode.StringToInteger;

public class Main {
    public static void main(String[] args) {
        String s="1337c0d3";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        return helper(s.trim(), 0, 1, 0L);
    }

    public static int helper(String s, int i, int sign, long result) {
        if (i >= s.length()) return (int)(sign * result);

        char ch = s.charAt(i);

        if (i == 0 && (ch == '+' || ch == '-')) {
            sign = (ch == '-') ? -1 : 1;
            return helper(s, i + 1, sign, result);
        }


        if (Character.isDigit(ch)) {
            result = result * 10 + (ch - '0');


            if (sign * result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign * result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

            return helper(s, i + 1, sign, result);
        }


        return (int)(sign * result);
    }
}


