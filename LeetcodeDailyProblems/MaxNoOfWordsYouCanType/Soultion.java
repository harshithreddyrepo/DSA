package DSA_with_kunal.LeetcodeDailyProblems.MaxNoOfWordsYouCanType;

class Solution {
    public static void main(String[] args) {
        String text="hello world";
        String brokenLetters="ad";
    }
    public static int canBeTypedWords(String text, String brokenLetters) {
        int count=0;
        String[] textWords=text.split(" ");
        for(int i=0;i<textWords.length;i++){
            for(int j=0;j<brokenLetters.length();j++){
                if(textWords[i].contains(""+brokenLetters.charAt(j))){
                    count++;
                    break;
                }

            }
        }
        return textWords.length-count;
    }
}
