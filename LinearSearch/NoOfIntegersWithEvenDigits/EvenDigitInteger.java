package DSA_with_kunal.LinearSearch.NoOfIntegersWithEvenDigits;

public class EvenDigitInteger {
    public static void main(String[] args) {
        int[] arr ={23,456,28,3,3231,2,489,300,243,9,-10} ;
        System.out.println(evenDigitIntegersCount(arr));

        System.out.println(digitsCount(-1234));
    }
    static int evenDigitIntegersCount(int[] arr) {
        int count=0,j;
        for(int i: arr) {
          j=0;
          while (i!=0) {
              i=i/10;
              j++;
          }
          if(j%2==0){
              count++;
          }
        }
        return count;
    }

    //** Shortcut to find no. of digits in an integer **//
    static int digitsCount(int num)
    {
        if(num<0)
            num=num*(-1);
        return (int)Math.log10(num)+1;
    }
}


