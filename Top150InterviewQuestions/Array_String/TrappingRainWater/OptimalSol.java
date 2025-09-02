package DSA_with_kunal.Top150InterviewQuestions.Array_String.TrappingRainWater;

class OptimalSol {
    public static void main(String[] args) {
        int[] height={4,2,0,3,2,5};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int prefixMax=height[0];
        int suffixMax=height[height.length-1];
        int l=1;
        int r=height.length-2;
        int water=0;
        while(l<=r){
            if(prefixMax<=suffixMax){
                prefixMax=Math.max(prefixMax,height[l]);
                water=water+prefixMax-height[l];
                l++;
            }else{
                suffixMax=Math.max(suffixMax,height[r]);
                water=water+suffixMax-height[r];
                r--;
            }
        }
        return water;

    }
}
