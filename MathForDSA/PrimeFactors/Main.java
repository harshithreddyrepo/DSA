package DSA_with_kunal.MathForDSA.PrimeFactors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n=100;
        System.out.println(Arrays.toString(AllPrimeFactors(n)));
    }
    public static int[] AllPrimeFactors(int N)
    {
        // code here
        List<Integer> list=new ArrayList<>();
        boolean[] primes=new boolean[N+1];
        for(int i=2;i*i<=N;i++){
            if(!primes[i]){
                for(int j=i*2;j<=N;j=j+i){
                    primes[j]=true;
                }
            }
        }
       // System.out.println("Running");
        for(int i=2;i<=N;i++){
            if(!primes[i]){
                if(N%i==0){
                    list.add(i);
                }
            }
        }
      //  System.out.println("Running");
        int[] arr=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
      //  System.out.println("Running");
        return arr;
    }
}
