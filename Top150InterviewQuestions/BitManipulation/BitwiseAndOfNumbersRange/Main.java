package DSA_with_kunal.Top150InterviewQuestions.BitManipulation.BitwiseAndOfNumbersRange;

public class Main {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(0,0));
    }
    public static int rangeBitwiseAnd(int left, int right) {
        if(left==0){
            return 0;
        }
        int count=0,i=1,min=left;
        while(min>1){
            min>>=1;
            count++;
        }
        if((right>>count)!=1){
            return 0;
        }else{
            i<<=count;
            while(count>0){
                if(((1<<(--count))&(left^right))==0){
                    if((left&(1<<count))==(1<<count)){
                        i+=1<<count;
                    }
                }else{
                    return i;
                }
            }
            return i;
        }



    }
}

