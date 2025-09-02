package DSA_with_kunal.MathForDSA;

import java.util.Arrays;

public class FlippingAnImage_17 {
    public static void main(String[] args) {
        int[][] arr ={{1,1,0},{1,0,1},{0,0,0}};
        filppinAnImage(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void filppinAnImage(int[][] arr){
        int temp;
        for(int i=0;i<arr.length;i++){
            for(int j=0,k=arr[i].length-1;j<k;j++,k--){
                temp = 1^arr[i][j];
                arr[i][j]=1^arr[i][k];
                arr[i][k]=temp;
            }
        }
    }
}
