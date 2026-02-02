package DSA_with_kunal.DynamicProgramming.MemoizationAndTabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems {

    // One-Dimensional DP

    // Q1. Climbing Stairs
        public int climbStairs(int n) {
            int[] table=new int[n+1];
            table[0]=1; // There is an only way when there are 0 steps.
            for(int i=0 ;i<=n; i++){
                if(i>0)  table[i]+=table[i-1];
                if(i>1) table[i]+=table[i-2];
            }
            return table[n];
        }

    // Q2. House Robbery
    public int rob(int[] nums) {
        int[] table=new int[nums.length+1];
        table[0]=0; // 0 houses
        table[1]=nums[0]; // 1 house
        for(int i=2; i<=nums.length; i++){
            table[i]=Math.max(nums[i-1]+table[i-2], table[i-1]);
        }
        return table[nums.length];
    }

    // Q3. Word Break
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            if (table[i]) {
                String newTarget = s.substring(i);
                for (int j = 0; j < wordDict.size(); j++) {
                    if (newTarget.startsWith(wordDict.get(j))) {
                        table[i + wordDict.get(j).length()] = true;
                    }
                }
            }
        }
        return table[s.length()];
    }

    // Q4. Coin Change
    public int coinChange(int[] coins, int amount) {
        int[] table=new int[amount+1];
        for(int i=0; i<=amount; i++){
            // initializing the default values.
            table[i]=-1;
        }
        table[0]=0; // trivial value (smallest input possible).
        for(int i=0; i<=amount; i++){
            if(table[i]!=-1){
                for(int j=0; j<coins.length; j++){
                    if(i+coins[j]>0 && i+coins[j]<=amount){
                        if(table[i+coins[j]]==-1 || table[i+coins[j]]>table[i]+1){
                            table[i+coins[j]]=table[i]+1;
                        }
                    }
                }
            }
        }
        return table[amount];
    }

    // Q5. Longest Increasing SubSequence
    public int lengthOfLIS(int[] nums) {
        int[] table=new int[nums.length];
        int maxLen=0;
        for(int i=0; i<nums.length; i++){
            table[i]=1;
        }
        for(int i=nums.length-1; i>=0; i--){
            int max=table[i];
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]<nums[j]){
                    max=Math.max(max, table[j]+1);
                }
            }
            table[i]=max;
            maxLen=Math.max(maxLen, max);
        }
        return maxLen;
    }

    // Multi-Dimensional DP

    // Q6.Triangle
    // Method 1: TOP_DOWN APPROACH
    public int minimumTotalTopDown(List<List<Integer>> triangle) {
        /*
        Let's do it using only O(n) extra space
        Thought process:
        =>Create an array of size n and use it to track updated columns in at each level.
        =>How it works?
         1.Preform the operation on the adjacent elements on the below row and store the updated value in the array.
         2.When we want to perform the operation on the updated value, take it from where it stored.
         3.when we move to the next row copy the values in the array into it.
         4.Repeat the process until the last level.
        */
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int minVal=Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size()-1; i++) {
            Integer[] arr = new Integer[triangle.size()];
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int cur = triangle.get(i).get(j);
                int adj1 = triangle.get(i + 1).get(j);
                int adj2 = triangle.get(i + 1).get(j + 1);
                //Consider jth element in the below row(i.e.,i+1).
                if (arr[j] == null || arr[j] > cur + adj1) {
                    arr[j] = cur + adj1;
                }
                //Consider j+1st element in the below row(i.e.,i+1).
                if (arr[j + 1] == null || arr[j + 1] > cur + adj2) {
                    arr[j + 1] = cur + adj2;
                }
            }
            // After completion of the current row copy the updated values into the triangle.
            // And also find the min value in it.
            minVal=Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i + 1).size(); j++) {
                triangle.get(i + 1).set(j, arr[j]);
                minVal=Math.min(minVal, arr[j]);
            }
        }
        return minVal;
    }

    // Method 2: BOTTOM-UP APPROACH
    public int minimumTotalBottomUp(List<List<Integer>> triangle) {
        // Start from the second to last row and move upwards
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // Current value + min(left child, right child)
                int currentVal = triangle.get(i).get(j);
                int lowerLeft = triangle.get(i + 1).get(j);
                int lowerRight = triangle.get(i + 1).get(j + 1);

                int pathSum = currentVal + Math.min(lowerLeft, lowerRight);

                // Update the current cell with the calculated path sum
                triangle.get(i).set(j, pathSum);
            }
        }
        // The top element now contains the minimum path sum
        return triangle.get(0).get(0);
    }

    // Q7. Minimum Path Sum
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int right= (j==n-1)?Integer.MAX_VALUE:grid[i][j+1];
                int down= (i==m-1)?Integer.MAX_VALUE:grid[i+1][j];
                // If right=Integer.MAX_VALUE && down==Integer.MAX_VALUE, we are currently at the bottom right position(DESTINATION).
                // then leave the value same as earlier.
                if(right!=Integer.MAX_VALUE || down!=Integer.MAX_VALUE){
                    grid[i][j]+=Math.min(right, down);
                }
            }
        }
        return  grid[0][0];
    }

    // Q8. Unique Paths II
    // Method 1: TOP-DOWN APPROACH
    public int uniquePathsWithObstaclesPush(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=-1;
                }
            }
        }
        obstacleGrid[0][0]=1; // Starting position-Trivial value.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j]>0){
                    // Update Right path.
                    if((j<n-1) && (obstacleGrid[i][j+1]>=0)){
                        obstacleGrid[i][j+1]+=obstacleGrid[i][j];
                    }
                    // Update Bottom Path.
                    if((i<m-1) && (obstacleGrid[i+1][j]>=0)){
                        obstacleGrid[i+1][j]+=obstacleGrid[i][j];
                    }
                }
            }
        }
        return obstacleGrid[m-1][n-1]==-1?0:obstacleGrid[m-1][n-1];
    }

    // Method 2: BOTTOM-UP APPROACH
    public int uniquePathsWithPull(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        obstacleGrid[m-1][n-1]=1;
        for(int row=m-1; row>=0; row--){
            for(int col=n-1; col>=0; col--){
                int right= (col==n-1)?0:obstacleGrid[row][col+1];
                int down= (row==m-1)?0:obstacleGrid[row+1][col];
                if(row!=m-1 || col!=n-1){  // Ensures the current cell is not the bottom right position of the grid.
                    obstacleGrid[row][col]= (obstacleGrid[row][col]==1)?0:(right+down);
                }
            }
        }
        return obstacleGrid[0][0];
    }

    // Q9.Longest Palindromic Substring
    public String longestPalindrome(String s) {
        int maxLen=1;
        String longStr=s.substring(0,1);
        int l=0;
        int r=0;
        for(int i=0; i<s.length(); i++){
            // Odd check
            l=i-1;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>maxLen){
                    maxLen=r-l+1;
                    longStr=s.substring(l,r+1);
                }
                l--;
                r++;
            }
            // Even check
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>maxLen){
                    maxLen=r-l+1;
                    longStr=s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return longStr;
    }

    // Q10.Partition Equal Subset Sum
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if((sum&1)==1){  // return false if odd.
            return false;
        }
        int target=sum/2;

        boolean[][] dp=new boolean[nums.length+1][target+1];

        // Initialization
        for(int r=0; r<=nums.length; r++){
            dp[r][0]=true;
        }
        for(int c=1; c<=target; c++){
            dp[0][c]=false;
        }

        for(int i=1; i<=nums.length; i++){
            for(int j=1; j<=target; j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[nums.length][target];
    }

    // Q11.Count Subsets With Sum K
    final static int M=1000000007;
    public static int findWays(int nums[], int tar) {

        int[][] dp=new int[nums.length+1][tar+1];

        // Initialization
        dp[0][0] = 1;

        // Fill the table
        for(int i=1; i<=nums.length;i++){
            for(int j=0; j<=tar; j++){
                if(nums[i-1]<=j){
                    dp[i][j]=(dp[i-1][j-nums[i-1]]+dp[i-1][j])%M;
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[nums.length][tar];
    }

    // Q12.Last Stone Weight II
    public int lastStoneWeightII(int[] stones) {
        int totalWeight=0;
        for(int i=0; i<stones.length; i++){
            totalWeight+=stones[i];
        }
        int halfWeight=totalWeight/2;

        boolean[][] dp=new boolean[stones.length+1][halfWeight+1];

        // Initialization
        for(int r=0; r<=stones.length; r++){
            dp[r][0]=true;
        }

        // Build the table
        for(int i=1; i<=stones.length; i++){
            for(int j=1; j<=halfWeight; j++){
                dp[i][j]=dp[i-1][j];
                if(stones[i-1]<=j){
                    dp[i][j]=dp[i][j] || dp[i-1][j-stones[i-1]];
                }
            }
        }

        // Check the nearest/closest possible subset sum to the halfWeight
        for(int c=halfWeight; c>=0; c--){
            if(dp[stones.length][c]){
                int s2 = totalWeight-c;
                return s2-c;
            }
        }

        return totalWeight;
    }

    // Q13.Target Sum
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int i=0; i<nums.length; i++){
            total+=nums[i];
        }

        if(((total+target)&1)==1 || target>total || (total+target)<0){
            return 0;
        }
        int s1=(total+target)/2;

        int[][] dp=new int[nums.length+1][s1+1];

        // Initialzation
        for(int r=0; r<=nums.length; r++){
            dp[r][0]=1;
        }

        // Build the table
        for(int i=1; i<=nums.length; i++){
            for(int j=0; j<=s1; j++){
                dp[i][j]=dp[i-1][j];
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][s1];
    }

    // Q14.Perfect Squares
    public int numSquares(int n) {
        int sqrt=(int)Math.sqrt(n);

        int[][] dp=new int[n+1][sqrt+1];

        // Initialization
        for(int r=1; r<=n; r++){
            dp[r][0]=Integer.MAX_VALUE;
        }

        // Build the table
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sqrt; j++){
                dp[i][j]=dp[i][j-1];
                if(i>=(j*j)){
                    dp[i][j]=Math.min((1+dp[i-j*j][j]), dp[i][j]);
                }
            }
        }
        return dp[n][sqrt];
    }

    // Q15.Coin Change II
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];

        // Initialization
        for (int r = 0; r <= coins.length; r++) {
            dp[r][0] = 1;
        }

        // Build the table
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }

    // Q16.Longest Common Subsequence
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];

        // Initialization will be done by default values

        // Build the table
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                char c1=text1.charAt(i-1);
                char c2=text2.charAt(j-1);
                if(c1==c2){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    // Q17.Combination Sum IV
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1; i<=target; i++){
            for(int j=0; j<nums.length; j++){
                if(i>=nums[j])
                    dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }

    // Q18.Maximum Length of Repeated Subarray
    public int findLength(int[] nums1, int[] nums2) {

        int[][] dp=new int[nums1.length+1][nums2.length+1];

        // Initialization will be done by the default values

        // Build the table
        for(int i=1; i<=nums1.length; i++){
            for(int j=1; j<=nums2.length; j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
            }
        }
        int max=0;
        for(int i=1; i<=nums1.length; i++){
            for(int j=1; j<=nums2.length; j++){
                max=Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    // Q19.Shortest Common Supersequence
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp=new int[str1.length()+1][str2.length()+1];

        // Initialization will be done by default values

        // Build the table
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                char c1=str1.charAt(i-1);
                char c2=str2.charAt(j-1);
                if(c1==c2){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Build the Shortest Common Supersequence using the table
        StringBuilder result=new StringBuilder();
        int m=str1.length();
        int n=str2.length();
        while(m>0 && n>0){
            if(str1.charAt(m-1)==str2.charAt(n-1)){
                result.insert(0,""+str1.charAt(m-1)); // Diagonal
                m--;
                n--;
            }else if(dp[m-1][n]>=dp[m][n-1]){
                result.insert(0,""+str1.charAt(m-1)); // Top
                m--;
            }else{
                result.insert(0,""+str2.charAt(n-1)); // Left
                n--;
            }

        }
        while(m>0){
            result.insert(0, str1.charAt(m-1));
            m--;
        }
        while(n>0){
            result.insert(0, str2.charAt(n-1));
            n--;
        }

        return result.toString();
    }

    // Q20.Edit Distance
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];

        // Initialization
        // i.0th row (word1="")
        for(int c=0; c<=word2.length(); c++){
            dp[0][c]=c;
        }
        // ii.0th column (word2="")
        for(int r=0; r<=word1.length(); r++){
            dp[r][0]=r;
        }

        // Build the table
        for(int i=1; i<=word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    // Q21.Longest Palindromic Subsequence
    public int longestPalindromeSubseq(String s) {
        String revStr=new StringBuilder(s).reverse().toString();
        return lcs(s, revStr);
    }
    private int lcs(String s1, String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];

        // Initialization wi be done by default values

        // Build the table
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // Q22.Minimum Insertion Steps to Make a String Palindrome
    public int minInsertions(String s) {
        String revStr=new StringBuilder(s).reverse().toString();
        int palindromicLen=scs(s, revStr);
        return palindromicLen-s.length();
    }
    private int scs(String s1, String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];

        // Initialization will be done by default values

        // Build the  table
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return s1.length()+s2.length()-dp[s1.length()][s2.length()];
    }


    // Q23.Matrix Chain Multiplication
    static int matrixMultiplication(int arr[]) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n][n];
        int matCnt=n-1;

        // Initialization will be done by default values
        for(int len=1; len<matCnt; len++){
            for(int i=1; i<=matCnt-len; i++){
                int j=i+len;
                int min=Integer.MAX_VALUE;

                for(int k=i; k<j; k++){
                    int temp=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    min=Math.min(min, temp);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][matCnt];
    }

    // Q24.Palindrome Partitioning
    // Method 1: Palindrome Recursion
    public List<List<String>> partition1(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> curList, List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(curList));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                curList.add(substring);
                backtrack(s, end, curList, result);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String substr) {
        for (int i = 0, j = substr.length() - 1; i < j; i++, j--) {
            if (substr.charAt(i) != substr.charAt(j))
                return false;
        }
        return true;
    }

    // Method 2: Palindrome DP
    public List<List<String>> partition2(String s) {
        int n=s.length();
        boolean[][] isPal=new boolean[n][n];
        // Precompute all palindrome substrings
        for(int len=1; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    isPal[i][j]=(len<=2)||isPal[i+1][j-1];
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result, isPal);
        return result;
    }

    private void backtrack(String s, int start, List<String> curList, List<List<String>> result, boolean[][] isPal) {

        if (start == s.length()) {
            result.add(new ArrayList<>(curList));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPal[start][end-1]) {
                curList.add(substring);
                backtrack(s, end, curList, result, isPal);
                curList.remove(curList.size() - 1);
            }
        }
    }

    // Q25.Palindrome Partitioning II
    // Method 1:- Time Complexity: O(n^4)
    public int minCut1(String s) {
        int[][] dp=new int[s.length()+1][s.length()+1];

        // Initialization will be done by default values

        // Build the table
        for(int len=1; len<s.length(); len++){
            for(int i=1; i<=s.length()-len; i++){
                int j=i+len;
                if(isPalindrome(s,i,j)){
                    dp[i][j]=0;
                }else{
                    int min=Integer.MAX_VALUE;
                    for(int k=i; k<j; k++){
                        int temp=dp[i][k]+dp[k+1][j]+1;
                        min=Math.min(min, temp);
                    }
                    dp[i][j]=min;
                }
            }
        }
        return dp[1][s.length()];
    }

    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start - 1, j = end - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    // Method 2:- Time Complexity: O(n^3)
    public int minCut2(String s) {
        int[][] dp=new int[s.length()+1][s.length()+1];

        // Initialization will be done by default values

        // Precompute all palindrome substrings
        boolean[][] isPal=new boolean[s.length()][s.length()];
        for(int len=1; len<=s.length(); len++){
            for(int i=0; i<=s.length()-len; i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    isPal[i][j]=(len<=2) || isPal[i+1][j-1];
                }
            }
        }
        // Build the table
        for(int len=1; len<s.length(); len++){
            for(int i=1; i<=s.length()-len; i++){
                int j=i+len;
                if(isPal[i-1][j-1]){
                    dp[i][j]=0;
                }else{
                    int min=Integer.MAX_VALUE;
                    for(int k=i; k<j; k++){
                        int temp=dp[i][k]+dp[k+1][j]+1;
                        min=Math.min(min, temp);
                    }
                    dp[i][j]=min;
                }
            }
        }
        return dp[1][s.length()];
    }

    // Method 3:- Time Complexity: O(n^2)
    public int minCut(String s) {
        int n=s.length();
        if(n<=1) return 0;
        // Step 1: Precompute all palindrome substrings
        boolean[][] isPal=new boolean[s.length()][s.length()];
        for(int len=1; len<=s.length(); len++){
            for(int i=0; i<=s.length()-len; i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    isPal[i][j]=(len<=2) || isPal[i+1][j-1];
                }
            }
        }

        // Step 2: 1D DP for minimum costs
        int[] dp=new int[n];
        for(int i=0; i<n; i++){
            if(isPal[0][i]){
                dp[i]=0; // No cuts needed if fthe whole prefix is a palimdrome.
            }else{
                int min=i; // Maximum possible cuts: one for each character
                for(int j=0; j<i; j++){
                    if(isPal[j+1][i]){
                        min=Math.min(min, dp[j]+1);
                    }
                }
                dp[i]=min;
            }
        }
        return dp[n-1];
    }

    // Q26.Minimum Cost to Cut a Stick
    // Method 1: Dp based on length of stick (TLE)
    public int minCost1(int n, int[] cuts) {
        boolean[] isValid=new boolean[n+1];
        // Build the validCuts
        for(int i=0; i<cuts.length; i++){
            isValid[cuts[i]]=true;
        }

        int[][] dp=new int[n+1][n+1];
        for(int len=2; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j=i+len;
                int min=Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    if(isValid[k]){
                        int temp=dp[i][k]+dp[k][j]+(j-i);
                        min=Math.min(min, temp);
                    }
                }
                dp[i][j]=(min==Integer.MAX_VALUE?0:min);
            }
        }
        return dp[0][n];
    }

    // Method 2: DP based on number of cuts
    public int minCost2(int n, int[] cuts) {
        // 1.Prepare the cut points: add 0 & 1 the sort
        int m=cuts.length;
        int[] newCuts=new int[m+2];
        for(int i=0; i<m; i++) newCuts[i+1]=cuts[i];
        newCuts[0]=0;
        newCuts[m+1]=n;
        Arrays.sort(newCuts);

        // 2.DP tabel based on index of cuts, not stick length
        int[][] dp=new int[m+2][m+2];

        // 3.len is the number of cut points in our current range
        for(int len=2; len<m+2; len++){
            for(int i=0; i<m+2-len; i++){
                int j=i+len;
                int min=Integer.MAX_VALUE;
                // Try every cut point between i and j
                for(int k=i+1; k<j; k++){
                    min=Math.min(min, dp[i][k]+dp[k][j]);
                }
                // cost=(min sub-problems)+(length of the current stick segment)
                // If no cuts found (min stays MAX), cost is 0
                dp[i][j]=(min==Integer.MAX_VALUE?0:min)+(newCuts[j]-newCuts[i]);
            }
        }
        return dp[0][m+1];
    }
}
