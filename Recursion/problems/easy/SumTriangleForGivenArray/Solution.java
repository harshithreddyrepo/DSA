package DSA_with_kunal.Recursion.problems.easy.SumTriangleForGivenArray;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] arr={4, 7, 3, 6, 7};
        System.out.println(getTriangle(arr));
    }
    static final int m=1000000007;
    public static ArrayList<Integer> getTriangle(int[] arr) {
        ArrayList<Integer> result=new ArrayList<>();
        if(arr.length==1){
            result.add(arr[0]);
            return result;
        }
        int[] nextArr=new int[arr.length-1];
        for(int i=0;i<nextArr.length;i++){
            nextArr[i]=(arr[i]+arr[i+1])%m;
        }
        result.addAll(getTriangle(nextArr));
        result.addAll(returnList(arr));
        return result;
    }

    public static List<Integer> returnList(int[] arr){
        List<Integer> res=new ArrayList<>();
        for(int n:arr){
            res.add(n);
        }
        return res;
    }
}
