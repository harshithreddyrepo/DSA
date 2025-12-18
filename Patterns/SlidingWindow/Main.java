package DSA_with_kunal.Patterns.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//      int[] nums={1,1,1,0,0,0,1,1,1,1,0};
//      System.out.println(longestOnes(nums,2));
//        String s= "abacccba";
//        int k=2;
        int[] nums={-1,2,9};
        System.out.println(subarraysDivByK(nums,2));

    }

    // Q1.Find the Maximum Sum of K Sized Subarray in an Array.
    public static double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double maxAvg=Integer.MIN_VALUE;
        double windowSum=0;
        for(int i=0;i<n;i++){
            windowSum+=nums[i];
            if(i>=k-1){
                maxAvg=Math.max(maxAvg, windowSum/k);
                windowSum-=nums[i-k+1];
          }
        }
        return maxAvg;
    }

   // Q6.Max Consecutive Ones III
   public static int longestOnes(int[] nums, int k) {
       int l=0;
       int r=0;
       int maxOnes=0;
       int count=k;
       while(r<nums.length){
           if(nums[r]==0){
               count--;
               while(count<0){
                   if(nums[l]==0){
                       count++;
                   }
                   l++;
               }
           }
           maxOnes=Math.max(maxOnes,r-l+1);
           r++;
       }
       return maxOnes;
   }

   // Q8.Permutation in String
   public boolean checkInclusion(String s1, String s2) {
       if(s1.length()>s2.length()){
           return false;
       }
       int l=0;
       int r=0;
       int[] freqMap=new int[26];
       int[] tempMap=new int[26];
       for(int i=0;i<s1.length();i++){
           freqMap[s1.charAt(i)-'a']++;
       }
       while(r<s2.length()){
           char ch=s2.charAt(r);
           tempMap[ch-'a']++;
           while(tempMap[ch-'a']>freqMap[ch-'a']){
               tempMap[s2.charAt(l)-'a']--;
               l++;
           }
           if(s1.length()==(r-l+1)){
               return true;
           }
           r++;
       }
       return false;
   }

   // Q9.Find All Anagrams in a String
   public List<Integer> findAnagrams(String s, String p) {
       List<Integer> list=new ArrayList<>();
       if(p.length()>s.length()){
           return list;
       }
       int l=0;
       int r=0;
       int[] freqMap=new int[26];
       int[] tempMap=new int[26];
       for(int i=0;i<p.length();i++){
           freqMap[p.charAt(i)-'a']++;
       }
       while(r<s.length()){
           char ch=s.charAt(r);
           tempMap[ch-'a']++;
           while(tempMap[ch-'a']>freqMap[ch-'a']){
               tempMap[s.charAt(l)-'a']--;
               l++;
           }
           if(p.length()==(r-l+1)){
               list.add(l);
           }
           r++;
       }
       return list;
   }

   // Q10. Longest Substring With At Most K Distinct Characters
    public static int longestSubstringAtMostK(String s, int k){
        int maxLen=0;
        int count=0;
        int r=0;
        int l=0;
        int[] freqMap=new int[26];
        while(r<s.length()){
            char ch=s.charAt(r);
            freqMap[ch-'a']++;
            if(freqMap[ch-'a']==1){
                count++;
                while(count>k){
                    ch=s.charAt(l);
                    freqMap[ch-'a']--;
                    if(freqMap[ch-'a']==0){
                        count--;
                    }
                    l++;
                }
            }
            maxLen= Math.max(maxLen, (r - l + 1));
            r++;
        }
        return maxLen;
    }

    // Q11. Subarrays With K Different Integers
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    static int helper(int[] nums, int k){
        int l=0;
        int r=0;
        int count=0;
        int distinct=0;
        int[] freqMap=new int[nums.length];
        while(r<nums.length){
            freqMap[nums[r]-1]++;
            if(freqMap[nums[r]-1]==1){
                distinct++;
                while(distinct>k){
                    freqMap[nums[l]-1]--;
                    if(freqMap[nums[l]-1]==0){
                        distinct--;
                    }
                    l++;
                }
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }

    // Q14. Subarray Sum Equals K
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }
        return count;
    }

    // Q16. Subarray Sums Divisible By K
    public static int subarraysDivByK(int[] nums, int k) {
        int count=0;
        int sum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[i]=sum%k;
            if(nums[i]<0){
                nums[i]+=k;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }
            count+=map.getOrDefault(nums[i],0);
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}
