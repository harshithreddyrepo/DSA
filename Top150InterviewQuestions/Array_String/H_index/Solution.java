package DSA_with_kunal.Top150InterviewQuestions.Array_String.H_index;

class Solution {
    public static void main(String[] args) {
        int[] citations={2,2};
        System.out.println(hIndex(citations));
    }


    public static int hIndex(int[] citations) {
        int len=citations.length;
        int[] papers=new int[len];
        for(int i=0;i<len;i++){
            if(citations[i]>=len){
                papers[len-1]++;
            }else{
                papers[citations[i]]++;
            }
        }
        for(int i=len-2;i>=0;i--){
            papers[i]=papers[i]+papers[i+1];
        }
        for(int i=0;i<len;i++){
            if(papers[i]>i){
                papers[i]=i;
            }
        }
        for(int i=len-1;i>0;i--){
            if(papers[i]==i){
                return i;
            }
        }

        return 0;
    }
}
