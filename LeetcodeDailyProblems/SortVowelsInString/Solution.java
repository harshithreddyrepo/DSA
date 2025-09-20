package DSA_with_kunal.LeetcodeDailyProblems.SortVowelsInString;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        char[] str=s.toCharArray();
        for (char c : "AEIOUaeiou".toCharArray()) {
            vowels.add(c);
        }
        List<Character> vowelsInStr=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(vowels.contains(s.charAt(i))){
                vowelsInStr.add(s.charAt(i));
            }
        }
        vowelsInStr.sort((x, y) -> Character.compare(x, y));
        int j=0;
        for(int i=0;i<str.length;i++){
            if(vowels.contains(str[i])){
                str[i]=vowelsInStr.get(j);
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            sb.append(c);
        }
        return sb.toString();

    }
}
