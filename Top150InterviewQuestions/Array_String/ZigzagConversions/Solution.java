package DSA_with_kunal.Top150InterviewQuestions.Array_String.ZigzagConversions;

class Solution {
    public static void main(String[] args) {
        String str="ABC";
        int rows=2;
        System.out.println(convert(str,rows));
    }
    public static String convert(String s, int numRows) {
        int len=s.length();
        if(s.length()<=numRows||numRows==1){
            return s;
        }
        int numCols=0;
        if(len%(2*numRows-2)==0){
            numCols=(numRows-1)*(len/(2*numRows-2));
        }else{
            numCols=((numRows-1)*(len/(2*numRows-2)))+numRows-1;
        }

        char[][] mat=new char[numRows][numCols];

        int k=0;
        for(int i=0;i<numCols;i++){
            if(i%(numRows-1)==0){
                for(int j=0;j<numRows;j++){
                    if(k<len){
                        mat[j][i]=s.charAt(k);
                        k++;
                    }
                }
            }else{
                if(k<len){
                    mat[numRows-(i%(numRows-1))-1][i]=s.charAt(k);
                    k++;
                }
            }if(k>=len){
                break;
            }
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                if(mat[i][j]!=0){
                    str=str.append(mat[i][j]);
                }

            }
        }
        return str.toString();

    }
}
