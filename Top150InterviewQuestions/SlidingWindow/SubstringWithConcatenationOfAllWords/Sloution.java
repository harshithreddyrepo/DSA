package DSA_with_kunal.Top150InterviewQuestions.SlidingWindow.SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
       String s ="wordgoodgoodgoodbestword";
       String[] words={"word","good","best","word"};
       String word=s.substring(16,18);
       System.out.println(findSubstring(s,words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> freqMap=new HashMap<>();
        for(String str:words){
            if(freqMap.containsKey(str)){
                freqMap.put(str,freqMap.get(str)+1);
            }else{
                freqMap.put(str,1);
            }
        }

        System.out.println(freqMap);

        List<Integer> result=new ArrayList<>();

        int size=words[0].length();

        int subStrLen=size*words.length;

        HashMap<String,Integer> currentCount=new HashMap<>(freqMap);

        int start=0;
        int end=0;
        int subLen=0;

        while(end+size-1<s.length()){
            String word=s.substring(end,end+size);
            if(freqMap.containsKey(word)){
                if(currentCount.get(word)>0){
                    end=end+size;
                    subLen+=size;
                    currentCount.put(word,currentCount.get(word)-1);
                }else{
                    start+=size;
                    end=start;
                    currentCount.putAll(freqMap);
                    subLen=0;
                }
            }else{
                start+=1;
                end=start;
                currentCount.putAll(freqMap);
                subLen=0;
            }
            if(subLen==subStrLen){
                result.add(start);
                currentCount.putAll(freqMap);
                start+=size;
                end=start;
                subLen=0;
            }
        }
        return result;
    }
}