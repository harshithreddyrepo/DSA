package DSA_with_kunal.Top150InterviewQuestions.Array_String.Candy;

class Solution {

    public static void main(String[] args) {
        int[] ratings={1,3,4,5,2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        if(ratings.length==1){
            return 1;
        }
        int sum=0;
        int[] count=new int[ratings.length];
        for(int i=0;i<count.length;i++){
            count[i]=1;
        }
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                count[i]=count[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                if(count[i]<=(count[i+1]+1)){
                    count[i]=count[i+1]+1;
                }

            }
        }
        for(int i=0;i<count.length;i++){
            sum=sum+count[i];
        }

        return sum;
    }
}
