package DSA_with_kunal.LeetcodeDailyProblems.NumberOfPeopleAwareOfSecret;
import java.util.HashMap;
class Solution {
    static final int M = 1000000007;
    static HashMap<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        int n=6;
        int delay=2;
        int forget=4;
        System.out.println(peopleAwareOfSecret(n,delay,forget));
    }

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int sum=0;
        map.clear();
        for(int day=n-forget+1;day<=n;day++){
            if(day>0){
                sum=(sum+solve(day,forget,delay))%M;
            }

        }
        return sum;
    }

    public static int solve(int day,int forget,int delay ){
        if(day==1){
            return 1;
        }
        if(map.containsKey(day)){
            return map.get(day);
        }

        int result=0;
        for(int prev=day-forget+1;prev<=day-delay;prev++){
            if(prev>0){
                result=(result+solve(prev,forget,delay))%M;
            }
        }
        map.put(day,result);
        return result;
    }
}
