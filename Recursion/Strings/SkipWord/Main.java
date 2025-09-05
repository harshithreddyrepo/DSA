package DSA_with_kunal.Recursion.Strings.SkipWord;

public class Main {
    public static void main(String[] args) {
        String s="An apple a day keeps doctor away";
        System.out.println(skipWord(s,"apple"));
    }

    public static String skipWord(String s,String word){
        if(s.length()<word.length()){
            return s;
        }
        if(s.startsWith(word)){
            return skipWord(s.substring(word.length()),word);
        }
        char ch=s.charAt(0);
        return ch+skipWord(s.substring(1),word);
    }
}
