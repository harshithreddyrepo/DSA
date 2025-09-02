package DSA_with_kunal.MathForDSA;

public class Question_2 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,1,2,1,3,6,4};
        int unique =0;
        for(int i:arr){
            unique^=i;
        }
        System.out.println(unique);
    }
}
