package DSA_with_kunal.DynamicProgramming.MemoizationAndTabulation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(canConstructTab("abcdef", new String[]{"ab","abc","cd","def","abcd"}));
//        System.out.println(canConstructTab("enterapotentpot", new String[]{"a","p","ent","enter","o","t","ot"}));
        System.out.println(countConstructTab("purple", new String[]{"purp","p","ur","le","purpl"}));
        System.out.println(countConstructTab("abcdef", new String[]{"ab","abc","cd","def","abcd","e","f"}));
        System.out.println(allConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd","ef","c"}));
    }
    // I. MEMOIZATION :

    // 1. Fib Memoization
    Map<Integer, Integer> fibMemo;
    public int fib(int n){
        if(fibMemo.containsKey(n)){
            return fibMemo.get(n);
        }
        if(n==1 || n==2){
            return 1;
        }
        int result=fib(n-1)+fib(n-2);
        fibMemo.put(n, result);
        return fibMemo.get(n);
    }
    /*
      Time Complexity;
      1.Without memoization: O(2^N) 'Exponential'.
      2.With memoization: O(N) 'Linear'.
     */

              //  ==============================================   //

    // 2. Grid Traveler Memoization
    /*
        To make the problem simple and conceptual oriented:
         1.Only Right and down moments are allowed.
         2.Starting position => (n,m)
         3.Goal or destination => (1,1)
     */
    static Map<String, Integer> gridTravelerMemo=new HashMap<>();
    public static int gridTraveller(int row, int col){
        String key=row+","+col;
        if(gridTravelerMemo.containsKey(key)){
           return gridTravelerMemo.get(key);
       }
        if(row==1 && col==1){
            return 1;
        }
        if(row<1 || col<1){
            return 0;
        }
        int result= gridTraveller(row-1, col) +  gridTraveller(row, col-1);
        gridTravelerMemo.put(key, result);
        return gridTravelerMemo.get(key);
    }
    /*
      Key Observation:
       => no. of possible paths from (m,n) {e.g., (1,2)} to destination (1,1) is same as
          no. of possible paths from (n,m) {e.g., (2,1)} to destination.

      Time Complexity:
      1.Without memoization: O(2^(m*n)) 'Exponential'
      2.With memoization: O(m*n) 'Linear'
    */

           //  =================================================  //

    // 3. Can Sum Memoization
    /*
       Return true if you can get the target value by adding the elements in the array.
       (e.g (target,values) => (7,[2,3,4,7])). Each element in the array can be used infinite times.
     */
    static Map<Integer, Boolean> canSumMemo=new HashMap<>();
    public static boolean canSum(int target, int[] nums){
        if(canSumMemo.containsKey(target)){
            return false;
        }
        if(target==0){
            return true;
        }
        if(target<0){
            return false;
        }
        for(int i=0; i<nums.length; i++){
            if(canSum(target-nums[i], nums)) return true;
        }
        canSumMemo.put(target, false);
        return false;
    }
    // Set data structure is more suitable than Map

           // ===================================== //

    // 4. How Sum Memoization
    /*

      => Write a function howSum(targetSum, numbers) that takes in targetSum and
        array of numbers as arguments.
      => The function should return an array containing any combination of the elements
        that add up to exactly the target sum. If there is the no combination that add up
        to the targetSum return null.
      => If there are multiple combinations possible, you may return any single one.

     */
    static Set<Integer> howSumMemo=new HashSet<>();
    public static List<Integer> howSum(int target, int[] nums){
        if(howSumMemo.contains(target)){
            return null;
        }
        if(target==0){
           return new ArrayList<>();
        }
        if(target<0){
          return null;
        }
        for(int i=0; i<nums.length; i++){
            List<Integer> bottom=howSum(target-nums[i], nums);
            if(bottom!=null){
                bottom.add(0, nums[i]);
                return bottom;
            }
        }
        howSumMemo.add(target);
        return null;
    }


    // 5. Best Sum Memoization
    /*
     => Write a function howSum(targetSum, numbers) that takes in targetSum and
        array of numbers as arguments.
     => The function should return an array containing the shortest combination
        of numbers that add up to exactly the targetSum.
     => If there is any tie for the shortest combination you can return any one
        of the combination.
     */
    static Map<Integer, List<Integer>> bestSumMemo=new HashMap<>();
    public static List<Integer> bestSum(int target, int[] nums){
      if(target==0){
          return new ArrayList<>();
      }
      if(bestSumMemo.containsKey(target)){
          return bestSumMemo.get(target);
      }
      if(target<0){
          return null;
      }
      // Here from the below calls we get list object if there is a valid combination
      // We need to find out the list with the minimum length and pass it to the above function calls.
      List<Integer> shortestCombination=null;
      for(int i=0; i<nums.length; i++){
         List<Integer> combination=bestSum(target-nums[i], nums);
         if(combination!=null){
             List<Integer> bottom=new ArrayList<>(combination);
             bottom.add(nums[i]);
             if(shortestCombination==null  || shortestCombination.size()>bottom.size()){
                 shortestCombination=bottom;
             }
         }
      }
      bestSumMemo.put(target, shortestCombination);
      return bestSumMemo.get(target);
    }

    // 6. Can Construct Memoization
    /*
     => Write a function canConstruct(target, wordBank) that accepts a target string
        and array of strings.
     => The function should return a boolean indicating whether the 'target'
        can be constructed by concatenating the elements of the 'wordBank' array.
     => you may reuse the elements of the wordBank as times as needed.
     */
    static HashMap<String, Boolean> canConstructMemo=new HashMap<>();
    public static boolean canConstruct(String target, String[] wordbank) {
        if(canConstructMemo.containsKey(target)){
            return canConstructMemo.get(target);
        }
        if (target.length() == 0) {
            return true;
        }
        for (String word : wordbank) {
            // Check if the target starts with the word
            if (target.startsWith(word)) {
                // Cut off ONLY the length of the word from the start
                String suffix = target.substring(word.length());

                if (canConstruct(suffix, wordbank)) {
                    return true;
                }
            }
        }
        canConstructMemo.put(target,false);
        return canConstructMemo.get(target);
    }

    // 7. Count Construct Memoization
    /*
     => Write a function countConstruct(target, wordBank) that accepts a target string
        and array of strings.
     => The function should return the number of ways that 'target' can be constructed
        by concatenating the elements of the 'wordBank' array.
     => you may reuse the elements of the wordBank as times as needed.
     */
    static Map<String, Integer> countConstructMemo=new HashMap<>();
    public static int countConstruct(String target, String[] wordBank){
        if(countConstructMemo.containsKey(target)){
            return countConstructMemo.get(target);
        }
        if(target.length()==0){
            return 1;
        }
        int count=0;
        for(int i=0; i< wordBank.length; i++){
            if(target.startsWith(wordBank[i])){
                String newTarget=target.substring(wordBank[i].length());
                count+=countConstruct(newTarget, wordBank);
            }
        }
        countConstructMemo.put(target, count);
        return countConstructMemo.get(target);
    }
    // 8. All Construct Memo
    /*
     => Write a function allConstruct(target, wordBank) that accepts a target string
        and array of strings.
     => The function should return all the combinations containing all the ways that the 'target'
        can be constructed by concatenating elements of 'wordBank' array
     => you may reuse the elements of the wordBank as times as needed.
     */
    public static List<List<String>> allConstruct(List<List<String>> result, List<String> processed, String target, String[] wordBank){
        if(target.length()==0){
           result.add(new ArrayList<>(processed));
           return result;
        }
        for(int i=0; i<wordBank.length; i++){
            if(target.startsWith(wordBank[i])){
                processed.add(wordBank[i]);
                String newTarget=target.substring(wordBank[i].length());
                allConstruct(result, processed, newTarget, wordBank);
                processed.removeLast();
            }
        }
        return result;
    }

    // Memoization Map: Stores target string -> all possible ways to construct it
    private static Map<String, List<List<String>>> memo = new HashMap<>();

    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        // 1. Check memo
        if (memo.containsKey(target)) return memo.get(target);

        // 2. Base Case
        if (target.isEmpty()) {
            List<List<String>> base = new ArrayList<>();
            base.add(new ArrayList<>()); // Add an empty list to represent one valid way
            return base;
        }

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());

                // 3. Recursive call for the remainder of the string
                List<List<String>> suffixWays = allConstruct(suffix, wordBank);

                // 4. Combine current word with all ways found for the suffix
                for (List<String> way : suffixWays) {
                    List<String> targetWay = new ArrayList<>();
                    targetWay.add(word);
                    targetWay.addAll(way);
                    result.add(targetWay);
                }
            }
        }

        // 5. Store in memo and return
        memo.put(target, result);
        return result;
    }

    // 2.TABULATION :

    // 1. Fib Tabulation
    public static int fibTab(int n){
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=0; i<=n; i++){
            if(i<n){
                arr[i+1]+=arr[i];
            }
            if(i<n-1){
                arr[i+2]+=arr[i];
            }
        }
        return arr[n];
    }
    /*
       Table: 1-D array of size n+1
       Default values: 0
       Trivial value: arr[0]=0 && arr[1]=1
     */

    // 2. Grid Traveler Tabulation
    public static int gridTravelerTab(int rows, int cols){
        int[][] grid=new int[rows+1][cols+1];
        grid[1][1]=1;
        for(int row=1; row<=rows; row++){
            for(int col=1; col<=cols; col++){
                if(row<rows){ // Bottom (row+1)
                    grid[row+1][col]+=grid[row][col];
                }
                if(col<cols){ // Right (col+1)
                    grid[row][col+1]+=grid[row][col];
                }
            }
        }
        return grid[rows][cols];
    }
     /*
       Table: 2-D array of size [row+1][col+1]
       Default values: 0
       Trivial value: arr[1][1]=1
     */

    // 3. Can Sum Tabulation
    public static boolean canSumTab(int target, int[] nums){
        boolean[] table=new boolean[target+1];
        table[0]=true; // The target 0 is always true.
        for(int i=0; i<=target; i++){
            if(table[i]){
                for(int j=0; j<nums.length; j++){
                    if((i+nums[j])<=target){
                        table[i+nums[j]]=true;
                    }
                }
            }
        }
        return table[target];
    }
     /*
       Table: 1-D array of size n+1
       Default values: false
       Trivial value: arr[0]=true
     */

    // 4. How Sum Tabulation
    public static int[] howSumTab(int target, int[] nums){
        int[][] table=new int[target+1][];
        table[0]=new int[]{};  // The target 0 can be constructed by empty array.
        for(int i=0; i<=target; i++){
            if(table[i]!=null){
                for(int j=0; j<nums.length; j++){
                    if(i+nums[j]<=target){
                        table[i+nums[j]]=new int[table[i].length+1];
                        table[i+nums[j]][0]=nums[j];
                        for(int k=0; k<table[i].length; k++){
                            table[i+nums[j]][k+1]=table[i][k];
                        }
                    }
                }
            }
        }
        return table[target];
    }


    // 5. Best Sum Tabulation
    public static int[] bestSumTab(int target, int[] nums){
        int[][] table=new int[target+1][];
        table[0]=new int[]{};
        for(int i=0; i<=target; i++){
            if(table[i]!=null){
                for(int j=0; j<nums.length; j++){
                    if(i+nums[j]<=target){
                        // Ensure that we have stored the shortest possible combination for each target sum.
                        if(table[i+nums[j]]==null || table[i+nums[j]].length>table[i].length+1){
                            table[i+nums[j]]=new int[table[i].length+1];
                            table[i+nums[j]][0]=nums[j];
                            for(int k=0; k<table[i].length; k++){
                                table[i+nums[j]][k+1]=table[i][k];
                            }
                        }
                    }
                }
            }
        }
        return table[target];
    }


    // 6. Can Construct Tabulation
    public static boolean canConstructTab(String target, String[] wordBank){
        boolean[] table=new boolean[target.length()+1];
        table[0]=true; // " "->empty string.
        for(int i=0; i<=target.length(); i++){
            if(table[i]){
                String newTarget=target.substring(i);
                for(int j=0; j< wordBank.length; j++){
                    if(newTarget.startsWith(wordBank[j])){
                        table[i+wordBank[j].length()]=true;
                    }
                }
            }
        }
        return table[target.length()];
    }
     

    // 7. Count Construct Tabulation
    public static int countConstructTab(String target, String[] wordBank){
        int[] table=new int[target.length()+1];
        table[0]=1; // " "->empty String.
        for(int i=0; i<=target.length(); i++){
            if(table[i]!=0){
                String newTarget=target.substring(i);
                for(int j=0; j<wordBank.length; j++){
                    if(newTarget.startsWith(wordBank[j])){
                        table[i+wordBank[j].length()]+=table[i];
                    }
                }
            }
        }
        return table[target.length()];
    }

    // 8. All Construct Tabulation
    public static List<List<String>> allConstructTab(String target, String[] wordBank){
        List<List<String>> [] table=new List[target.length()+1];
        table[0]=new ArrayList<>();
        for(int i=0; i<target.length()+1; i++){
            if(table[i]!=null){
                String newTarget=target.substring(i);
                for(int j=0; j<wordBank.length; j++){
                    if(newTarget.startsWith(wordBank[j])){
                        List<List<String>> newcombinations=new ArrayList<>();
                        for(List<String> prev: table[i]){
                            prev.add(wordBank[j]);
                        }
                        if(table[i+wordBank[j].length()]!=null){
                            table[i+wordBank[j].length()].addAll(newcombinations);
                        }else{
                            table[i+wordBank[j].length()]=newcombinations;
                        }
                    }
                }
            }
        }
        return table[target.length()];
    }
}

