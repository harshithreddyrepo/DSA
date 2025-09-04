package DSA_with_kunal.Questions.PalindromeNumber;

public class Main {
    public static void main(String[] args) {
        int num=12345;
        System.out.println(palindrome(num,0,num));
    }
    public static boolean palindrome(int num,int rev,int ref){
        if(num==0){
            if(rev==ref){
                return true;
            }
            return false;
        }
        int rem=num%10;
        rev=rev*10+rem;
        return palindrome(num/10,rev,ref);
    }
}
