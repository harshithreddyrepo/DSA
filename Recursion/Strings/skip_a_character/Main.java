package DSA_with_kunal.Recursion.problems.easy.skip_a_character;

public class Main {
    public static void main(String[] args) {
        String s="baccab";
        System.out.println(skipCharacter2(s,'c',0));
    }
    public static String skipCharacter(String s,String res,int p,char ch){
        if(p>=s.length()){
            return res;
        }
        StringBuilder sb=new StringBuilder(res);
        if(s.charAt(p)!=ch){
            sb.append(s.charAt(p));
        }
        return skipCharacter(s, sb.toString(), p+1,ch);
    }

    public static String skipCharacter2(String s,char ch,int p){
        if(p>=s.length()){
            return "";
        }
        if(s.charAt(p)!=ch){
            return s.charAt(p)+skipCharacter2(s,ch,p+1);
        }
        return skipCharacter2(s,ch,p+1);
    }
}
