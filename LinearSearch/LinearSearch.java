package DSA_with_kunal.LinearSearch;
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={12,33,42,15,26,62,19,43,25,92,84,76,5,2,13,24};
        System.out.println(linerSearch1(84,arr));
        System.out.println(linerSearch2(84,arr));
        System.out.println(linerSearch3(84,arr));
    }
    // it returns the index of the target element if it is found else it returns -1
    public static int linerSearch1(int target,int[] arr) {
        if(arr.length==0) {
            return -1;
        }
        else {
            for(int i=0;i<arr.length;i++) {
                if(arr[i]==target)
                    return i;
            }
        }
        return -1;
    }
    // it returns the target element if it is found else it returns Maximum value that can be stored in integer variable
    public static int linerSearch2(int target,int[] arr) {
        if(arr.length==0) {
            return Integer.MAX_VALUE;
        }
        else {
            for(int i:arr) {
                if(target==i)
                    return i;
            }
        }
        return Integer.MAX_VALUE;
    }
    // it returns true if the target element is found else it returns false
    public static boolean linerSearch3(int target,int[] arr)
    {
        if(arr.length==0) {
            return false;
        }
        else {
            for(int i:arr) {
                if(target==i)
                    return true;
            }
        }
        return false;
    }
}
