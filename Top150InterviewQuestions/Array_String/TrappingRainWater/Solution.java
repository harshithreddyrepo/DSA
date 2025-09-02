package DSA_with_kunal.Top150InterviewQuestions.Array_String.TrappingRainWater;

class Solution {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int water=0;
        int i=0;
        int j=0;
        while(i<height.length-1){
            if(height[i]==0){
                i++;
            }else{
                j=i+1;
                int max=0;
                int p=0;
                while((j<height.length)&&(height[j]<height[i])){
                    if(max<height[j]){
                        max=height[j];
                        p=j;
                    }
                    j++;
                }
                if(j==height.length){
                    j=p;
                }if(j==i+1){
                    i++;
                    continue;
                }else{

                    for(int k=i+1;k<j;k++){
                        if(height[i]<=height[j]){
                            water+=height[i]-height[k];
                        }else{
                            water+=height[j]-height[k];
                        }
                    }
                    i=j;
                }

            }
        }
        return water;
    }
}
