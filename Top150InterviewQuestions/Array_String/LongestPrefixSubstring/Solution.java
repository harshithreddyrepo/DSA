package DSA_with_kunal.Top150InterviewQuestions.Array_String.LongestPrefixSubstring;

class Solution {
    public static void main(String[] args) {
        String[] strs={"ab","a"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        if(len==1){
            return strs[0];
        }
        int j=0;
        char ch;
        while(j<strs[0].length()){
            ch=strs[0].charAt(j);
            for(int i=1;i<len;i++){

                if((j<strs[i].length())&&strs[i].charAt(j)==ch){
                    continue;
                }else{
                    return strs[i].substring(0,j);
                }



            }
            j++;
        }

        return strs[0];

    }
}
