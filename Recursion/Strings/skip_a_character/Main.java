package DSA_with_kunal.Recursion.Strings.skip_a_character;

public class Main {
    public static void main(String[] args) {
        String s="baccab";
       // System.out.println(skipCharacter2(s,'c',0));
       // skip("","baabaccad");
       // System.out.println(skip2("","bcabaacd"));
        System.out.println(skip3("baccab"));
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

    public static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        if(up.charAt(0)!='a'){
            skip(p+up.charAt(0),up.substring(1));
        }else{
            skip(p,up.substring(1));
        }

    }

    public static String skip2(String p,String up){
        if(up.isEmpty()){
            return p;
        }
        if(up.charAt(0)!='a'){
           return skip2(p+up.charAt(0),up.substring(1));
        }
        return skip2(p,up.substring(1));
    }

    public static String skip3(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(ch!='a'){
            return ch+skip3(up.substring(1));
        }
        return skip3(up.substring(1));
    }
}
