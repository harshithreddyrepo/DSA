package DSA_with_kunal.LeetcodeDailyStreak.Find_N_UniqueIntegersSumUpToZero;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      int n=5;
        System.out.println(Arrays.toString(sumZero(n)));
    }
    public static int[] sumZero(int n) {
        int[] arr=new int[n];
        int i=0;
        int j=1;
        int val=1;
        if(n%2==1)
        {
            arr[i]=0;
            i++;
            j++;
        }
        while(j<n)
        {
            arr[i]=val;
            arr[j]=-val;
            val++;
            i=i+2;
            j=j+2;
        }
        return arr;
    }
}
