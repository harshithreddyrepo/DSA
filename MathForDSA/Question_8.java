package DSA_with_kunal.MathForDSA;
import java.lang.Math;
import java.util.Arrays;

// Find the no n from the array which is repeated only once instead of thrice.
public class Question_8 {
    public static void main(String[] args) {
        int[] data={1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,10};
        int[] arr = new int[8];
        int[] binaryArray;
        for(int i=0;i<data.length;i++){
            binaryArray=convertToBinaryArray(data[i]);
            int k=arr.length-1;
            for(int j=binaryArray.length-1;j>=0;j--){
                arr[k]+=binaryArray[j];
                k--;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]%=3;
        }
        StringBuilder result = new StringBuilder();
        for (int value : arr) {
            result.append(value); // Append each element to the string
        }

        // String binaryString = result.toString();
        // System.out.println("Binary String: " + binaryString);
        int uniqueVal = Integer.parseInt(String.valueOf(result),2);
        System.out.println(uniqueVal);

        // System.out.println(Arrays.toString(arr));

   }
    public static int[] convertToBinaryArray(int number) {
        String binaryString = Integer.toBinaryString(number);
        int[] binaryArray = new int[binaryString.length()];
        for (int i = 0; i < binaryString.length(); i++) {
            binaryArray[i] = binaryString.charAt(i) - '0';
        }
        return binaryArray;
    }

}

/*
        int[] arr = {1,1,1,3,3,3,11,11,11,7};
        String binary;
        int bitSum=0;
        for(int i : arr){

            binary = Integer.toBinaryString(i);
            System.out.println(binary);
            bitSum = bitSum + Integer.parseInt(binary);
        }
        System.out.println(bitSum);
        int binarySum=0;
        int i=0;
        while(bitSum!=0){
             binarySum = binarySum + (((bitSum%10)%3)*(int)Math.pow(10,i));
             i++;
             bitSum = bitSum/10;
        }
        System.out.println(binarySum);
        binary=Integer.toString(binarySum);
        binarySum=Integer.parseInt(binary,2);
        System.out.println(binarySum);

         */
