package DSA_with_kunal.Top150InterviewQuestions.Math.Sqrt;

public class Main {
    public static void main(String[] args) {
        int x=8;
        int precision=5;
        System.out.println(mySqrtBinarySearchTechnique(x,precision));
        System.out.println(mySqrtNrmTechnique(8));
    }
    public static double mySqrtBinarySearchTechnique(int x,int p) {
        long start=1;
        double end=x;
        long mid=0;
        while(start<=end){
            mid= (long) (start+(end-start)/2);
            //System.out.println(mid);
            if(mid*mid==x){
                return (int)mid;
            }else if((mid*mid)>x){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        double pre=0.1;
        for(int i=0;i<p;i++){
            double incr=pre;
            while((end)*(end)<=x){
                end=end+incr;
            }
            end=end-incr;
           // System.out.println(pre);
            pre=pre/10;
    }
        return end;
    }

    public static double mySqrtNrmTechnique(int n) {  //NEWTON RAPHSON METHOD
        double x = n, root;
        while (true) {
            root = 0.5 * (x + n / x);
            if (Math.abs(root - x) < 0.001) {
                break;
            }
            x = root;
        }
        return root;
    }
}
