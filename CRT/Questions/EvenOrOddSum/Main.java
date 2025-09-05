package DSA_with_kunal.CRT.Questions.EvenOrOddSum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter two integer values:");
        Scanner sc=new Scanner(System.in);
        int source= sc.nextInt();
        int target=sc.nextInt();
        evenOrOddSum(source,target);
    }

    public static void evenOrOddSum(int source,int target){
        boolean even=false;
        int sum=0;
        if(source<target){
            even=true;
        }else{
            int temp=source;
            source=target;
            target=temp;
        }
        if(source==target){
            System.out.println("Both integers are equal");
        }else{
            for(int i=source;i<=target;i++){
                if(even==true && i%2==0 ){
                    sum=sum+i;
                }
                if(even==false && (i%2==1 || i%2==-1)){
                    sum=sum+i;
                }
            }
            System.out.println(sum);
        }
    }
}
