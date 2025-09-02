package DSA_with_kunal.Recursion.Patterns;

/*
   Pattern 1:
     * * * * *
     * * * *
     * * *
     * *
     *

 */

/*

 Pattern 2:
     *
     * *
     * * *
     * * * *
     * * * * *

 */

public class Main {
    public static void main(String[] args) {
        int row=5;
        pattern2(row,0);
    }

    public static void pattern1(int row,int col){
        if(row==0){
            return;
        }
       if(col<row){
           System.out.print("* ");
           pattern1(row,col+1);
       }else{
           System.out.println();
           pattern1(row-1,0);
       }

    }

    public static void pattern2(int row,int col){
        if(row==0){
            return;
        }
        if(col<row){
            pattern2(row,col+1);
            System.out.print("* ");

        }else{
            pattern2(row-1,0);
            System.out.println();

        }
    }
}
