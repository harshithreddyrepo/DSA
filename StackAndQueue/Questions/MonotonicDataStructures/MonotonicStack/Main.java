package DSA_with_kunal.StackAndQueue.Questions.MonotonicDataStructures.MonotonicStack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       int[] heights={1,1};
       int[] nums={5,4,3,2,1};
       // System.out.println(largestRectangleArea(heights));
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    /*
     Q1. Daily Temperatures
       Given an array of integers temperatures represents the daily temperatures,
       return an array answer such that answer[i] is the number of days you have
       to wait after the ith day to get a warmer temperature. If there is no
       future day for which this is possible, keep answer[i] == 0 instead.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] result=new int[n];
        int[] stack=new int[n];
        int ptr=-1;
        for(int i=n-1;i>=0;i--){
            while(ptr!=-1 && temperatures[stack[ptr]]<=temperatures[i]){
                ptr--;
            }
            if(ptr==-1){
                result[i]=0;
            }else{
                result[i]=stack[ptr]-i;
            }
            stack[++ptr]=i;
        }

        return result;
    }

    /*
     Q2. Largest Rectangle in Histogram

     */
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] stack=new int[n];
        int ptr=-1;

        // Construct (Next Smaller Element to Left) NSEL Array
        for(int i=0;i<n;i++){
            while(ptr!=-1 && heights[stack[ptr]]>=heights[i]){
                ptr--;
            }
            if(ptr==-1){
                left[i]=-1;
            }else{
                left[i]=stack[ptr];
            }
            stack[++ptr]=i;
        }
        System.out.println(Arrays.toString(left));
        // Construct (Next Smaller Element to Right) NSER Array
        ptr=-1;
        for(int i=n-1;i>=0;i--){
            while(ptr!=-1 && heights[stack[ptr]]>=heights[i]){
                ptr--;
            }
            if(ptr==-1){
                right[i]=-1;
            }else{
                right[i]=stack[ptr];
            }
            stack[++ptr]=i;
        }
        System.out.println(Arrays.toString(right));
        int maxArea=0;
        for(int i=0;i<n;i++){
            if(left[i]==-1 && right[i]==-1){
                maxArea=Math.max((heights[i]*n), maxArea);
            }else if(left[i]==-1 && right[i]!=-1){
                maxArea=Math.max((heights[i]*right[i]), maxArea);
            }else if(left[i]!=-1 && right[i]==-1){
                maxArea=Math.max((heights[i]*(n-left[i]-1)), maxArea);
            }else{
                maxArea=Math.max((heights[i]*(right[i]-left[i]-1)), maxArea);
            }
        }
        return maxArea;

    }

    /*
     Q3. Next Greater Element II
     Given a circular integer array nums (i.e., the next element of nums[nums.length - 1]is nums[0]),
      return the next greater number for every element in nums.
     */
    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            result[i]=-1;
        }
        int[] stack=new int[n];
        int ptr=-1;
        for(int i=2*n-1;i>=0;i--){
            while(ptr!=-1 && stack[ptr]<=nums[i%n]){
                ptr--;
            }
            if(ptr!=-1){
                result[i%n]=stack[ptr];
                visited[i%n]=true;
            }else{
                result[i%n]=-1;
            }

            stack[++ptr]=nums[i%n];

        }

        return result;

    }

}
