package DSA_with_kunal.StackAndQueue.Questions.MonotonicDataStructures.MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,3,2,5};
        System.out.println(Arrays.toString(resultsArray(nums, 3)));
    }

    /*
      Q1.Sliding Window Maximum
      You are given an array of integers nums, there is a sliding window of size k which is moving from
      the very left of the array to the very right. You can only see the k numbers in the window.
      Each time the sliding window moves right by one position.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if(!deque.isEmpty() && i>=k-1){
                if(i-deque.peekFirst()>=k){
                    deque.pollFirst();
                }
                result[i-k+1]=nums[deque.peekFirst()];
            }
        }
        return result;
    }

    /*
      Q2.Find the power of k-size sub-arrays II
      You are given an array of integers nums of length n and a positive integer k.
      The power of an array is defined as:
      Its maximum element if all of its elements are consecutive and sorted in ascending order.
      -1 otherwise.

      Thought process:
      i.We need to track the elements of each sub-array and verify that are they sorted
      and return the max value if sorted.
      // How to ensure the elements are sorted:
      ii.Store the elements of each k-sized sub array in a monotonic increasing queue
          a) if the size of deque is equal to the k then the elements are in sorted order.
          b) if the size of deque is less than k then the elements are not in sorted order.
      // How to ensure the Deque stores the elements of single sub-array:
      iii.We are inserting the elements sequentially into the deque let current element is at ith index in array,
          a) only the elements with index value form i-k+1 to ith belongs to the single sub-array
             having ith index as last element.
          b) all the elements with the index  value less than i-k-1 should be removed sequentially.
       iv. Remember the difference is 1.
    */
    public static int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int[n-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<n;i++){
           while(!deque.isEmpty() && (nums[deque.peekLast()]>=nums[i] ||nums[deque.peekLast()]<(nums[i]-1))){
               deque.pollLast();
           }
           deque.offer(i);
           if(i>=k-1){
               if(deque.peekFirst()<=i-k){
                   deque.pollFirst();
               }
               if(deque.size()==k){
                   result[i-k+1]=nums[deque.peekLast()];
               }else{
                   result[i-k+1]=-1;
               }
           }
        }
        return result;
    }

    /*
      Q3.Shortest Subarray With Sum at Least k
      Given an integer array nums and an integer k, return the length of the shortest
      non-empty subarray of nums with a sum of at least k. If there is no such subarray,
      return -1.
     */

    public int shortestSubarray(int[] nums, int k) {
        int minSize=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=nums[0];
        while(right<nums.length){
            if(sum>=k){
                minSize=Math.min(right-left+1, minSize);
                sum-=nums[left];
                left++;
            }else{
                ++right;
                if(right<nums.length){
                    sum+=nums[right];
                }

            }
        }
        return  minSize==Integer.MAX_VALUE?-1:minSize;
    }
    
}
