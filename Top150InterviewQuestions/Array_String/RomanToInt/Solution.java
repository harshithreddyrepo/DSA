package DSA_with_kunal.Top150InterviewQuestions.Array_String.RomanToInt;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        String str="LVIII";
        System.out.println(romanToInt(str));  //58
    }
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanInt = new HashMap<>();
        romanInt.put('I', 1);
        romanInt.put('V', 5);
        romanInt.put('X', 10);
        romanInt.put('L', 50);
        romanInt.put('C', 100);
        romanInt.put('D', 500);
        romanInt.put('M', 1000);

        int intValue=0;
        int val=0;
        int len=s.length();
        int preVal=0;
        for(int i=len-1;i>=0;i--){
            val=romanInt.get(s.charAt(i));
            if(val<preVal){
                intValue-=val;
            }else{
                intValue+=val;
            }
            preVal=val;
        }
        return intValue;
    }
}
