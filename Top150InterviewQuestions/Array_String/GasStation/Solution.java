package DSA_with_kunal.Top150InterviewQuestions.Array_String.GasStation;

class Solution {
    public static void main(String[] args) {
       int[] gas ={5,8,2,8};
       int[] cost ={6,5,6,6};

        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int flag=0;
        int start=0;
        int balance=0;
        for(int i=0;i<n;i++){
            gas[i]-=cost[i];
            flag+=gas[i];
        }
        if(flag<0){
            return -1;
        }
        for(int i=1;i<n;i++){
            balance+=gas[i]+gas[i-1];
            if(balance<0){
                start=(i+1);
                balance=0;
            }
        }
        return start;
    }
}
