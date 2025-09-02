package DSA_with_kunal.BinarySearch.Questions.Q3smallest_letter_greater_than_target;
 public class Main {
    public static void main(String[] args) {
       char[] arr = {'A','C','G','L','M','Q','R','Z'};
        System.out.println(ceilingCharacter('N',arr));
    }
    static public char ceilingCharacter(char target,char[] arr){
        int start=0,end=arr.length-1,mid;
        while (start<=end){
            mid = start+(end-start)/2;
            if(target==arr[mid]){
                if(mid<arr.length-1)
                    return arr[++mid];
                else
                    return arr[(start%(arr.length-1))];
            } else if (target>arr[mid]) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return arr[(start%arr.length)];
    }
}
