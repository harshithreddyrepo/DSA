package DSA_with_kunal.Top150InterviewQuestions.Array_String.TextJustification;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        String[] words={"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth=20;
       // System.out.println(fullJustify(words,maxWidth));
        fullJustify(words,maxWidth).stream().forEach(x-> System.out.println(x));
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int i=0;
        int j=0;
        int w=0;
        int n=0;
        int line=0;
        int spaces=0;
        ArrayList<String> list=new ArrayList<>();
        HashMap<Integer, Integer> wordsPerLine = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> spacesPerLine = new HashMap<Integer, Integer>();
        while(i<words.length){
            n=n+words[i].length();
            spaces=maxWidth-n;
            if((n+j)<=maxWidth){
                wordsPerLine.put(line,++w);
                spacesPerLine.put(line,spaces);
                i++;
                j++;
            }else{
                line++;
                n=0;
                spaces=0;
                j=0;
                w=0;
            }
        }
        int numOfLines=wordsPerLine.size();
        StringBuilder[] strings=new StringBuilder[numOfLines];
        for(i=0;i<numOfLines;i++){
            strings[i]=new StringBuilder();
        }
        line=0;
        i=0;
        j=0;
        while(line<numOfLines){
            int space=wordsPerLine.get(line)>1?spacesPerLine.get(line)/(wordsPerLine.get(line)-1):spacesPerLine.get(line);
            int extraSpace=wordsPerLine.get(line)>1?spacesPerLine.get(line)%(wordsPerLine.get(line)-1):0;
            if(line==(numOfLines-1)){
                space=1;
                extraSpace=0;
            }

            strings[line].append(words[i]);
            i++;
            for(j=1;j<wordsPerLine.get(line);j++){

                for(int k=0;k<space;k++){
                    strings[line].append(" ");
                }
                if(extraSpace!=0){
                    strings[line].append(" ");
                    extraSpace--;
                }
                strings[line].append(words[i]);
                i++;
            }
            if(strings[line].length()<maxWidth){
                for(int x=strings[line].length();x<maxWidth;x++){
                    strings[line].append(" ");
                }
            }
            list.add(strings[line].toString());
            line++;
        }

        return list;



    }
}