package DSA_with_kunal.LeetcodeDailyProblems.VowelSpellChecker;

import java.util.*;

class Solution {
    public static void main(String[] args) {
       String[] wordlist={"KiTe","kite","hare","Hare"};
       String[] queries={"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
       System.out.println(Arrays.toString(spellChecker2(wordlist,queries)));
    }

    // Using only for loop
    public static String[] spellchecker1(String[] wordlist, String[] queries) {
        HashMap<String,String> dp=new HashMap<>();
        for(int i=0;i<queries.length;i++){
            if(dp.containsKey(queries[i])){
                queries[i]=dp.get(queries[i]);
            }else{
                String correctWord="";
                boolean flag1=true;
                boolean flag2=true;
                for(String word:wordlist){
                    if(word.equals(queries[i])){
                        correctWord=word;
                        queries[i]=word;
                        break;
                    }else if(word.equalsIgnoreCase(queries[i])&&flag1){
                        correctWord=word;
                        flag1=false;
                    }else if((word.length()==queries[i].length()&&flag1&&flag2)){
                        boolean vowCor=true;
                        for(int j=0;j<word.length();j++){
                            char q=Character.toLowerCase(queries[i].charAt(j));
                            char w=Character.toLowerCase(word.charAt(j));
                            if(!(q=='a'||q=='e'||q=='i'||q=='o'||q=='u')){
                                if(!(w=='a'||w=='e'||w=='i'||w=='o'||w=='u')){
                                    if(q!=w){
                                        vowCor=false;
                                        break;
                                    }
                                }else{
                                    vowCor=false;
                                    break;
                                }
                            }else{
                                if(!(w=='a'||w=='e'||w=='i'||w=='o'||w=='u')){
                                    vowCor=false;
                                    break;
                                }
                            }
                        }
                        if(vowCor){
                            correctWord=word;
                            flag2=false;
                        }
                    }
                }
                dp.put(queries[i],correctWord);
                queries[i]=correctWord;

            }

        }
        return queries;
    }

    //Using HashSet
    public static String[] spellChecker2(String[] wordlist, String[] queries){
        String[] result=new String[queries.length];
        Set<String> exactMatch=new HashSet<>();
        Map<String,String> caseInSensitiveMatch=new HashMap<>();
        Map<String,String> vowelMisMatch=new HashMap<>();
        for(String word:wordlist){
            exactMatch.add(word);
            caseInSensitiveMatch.putIfAbsent(word.toLowerCase(),word);
            vowelMisMatch.putIfAbsent(word.toLowerCase().replaceAll("[aeiou]","*"),word);
        }
       for(int i=0;i<result.length;i++){
           if(exactMatch.contains(queries[i])){
               result[i]=queries[i];
           } else if (caseInSensitiveMatch.containsKey(queries[i].toLowerCase())) {
               result[i]=caseInSensitiveMatch.get(queries[i].toLowerCase());
           }else {
               result[i]=vowelMisMatch.getOrDefault(queries[i].toLowerCase().replaceAll("[aeiou]","*"),"");
           }
       }
       return result;
    }
}