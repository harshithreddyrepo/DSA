package DSA_with_kunal.Top150InterviewQuestions.TwoPointers.ValidPalindrome;

class Solution {
    public static void main(String[] args) {
        String str="0P";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        char ich;
        char jch;
        while(i<j){
            ich=s.charAt(i);
            jch=s.charAt(j);
            if(ich<97 || ich>122){
                i++;
            }else if(jch<97 || jch>122){
                j--;
            }else{
                if(ich!=jch){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
