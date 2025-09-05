package DSA_with_kunal.Recursion.Strings.SkipWordIfNotRequiredWord;
// write a function that should skip "app" only if it is not the word "apple".
public class Main {
    public static void main(String[] args) {
        String s="itisappleapplication";
        System.out.println(skipAppIfNotApple(s));
    }
    public static String skipAppIfNotApple(String s){
        if(s.length()<"app".length()){
            return s;
        }
        if(s.startsWith("app")&&(!s.startsWith("apple"))){
            return skipAppIfNotApple(s.substring("app".length()));
        }
        char ch=s.charAt(0);
        return ch+skipAppIfNotApple(s.substring(1));
    }
}
