package DSA_with_kunal.Heaps;

import DSA_with_kunal.LinkedList.Questions;

import java.util.*;

public class Problems {
    // Q1.Find Median From Data Stream
    class MedianFinder {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;
        public MedianFinder() {
            maxHeap=new PriorityQueue<>(Comparator.reverseOrder()); // Left Heap
            minHeap=new PriorityQueue<>();  // Right Heao
        }

        public void addNum(int num) {
            maxHeap.offer(num); // Left
            if(!minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()){
                minHeap.offer(maxHeap.poll());
            }

            if(maxHeap.size()>minHeap.size()+1){
                minHeap.offer(maxHeap.poll());
            }
            if(minHeap.size()>maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size()>minHeap.size()){
                return maxHeap.peek();
            }else{
                return (double)(maxHeap.peek()+minHeap.peek())/2;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

   // Q2.Kth Largest Element in an Array
public int findKthLargest(int[] nums, int k) {
    int n=nums.length;
    for(int i=n/2;i>=0;i--){
        downHeap(nums, i, nums.length);   // Max heap is constructed from given array (T.C O(Nlog(N)))
    }
    // The Top of the heap will contain max element among all the elements in heap
    // Replace the Top element with last element of heap for k-1 times,
    // for the Kth time the Top element will be the Kth largest element.
    for(int j=1; j<k; j++){
        swap(nums, 0, n-j);
        downHeap(nums, 0, n-j);
    }
    return nums[0];
}
    private void downHeap(int[] nums, int i, int end){
        if(left(i)>=end){  // Exclusive end
            return;
        }
        int max=i;
        if(nums[left(i)]>nums[i]){
            max=left(i);
        }
        if(right(i)<end && nums[right(i)]>nums[max]){
            max=right(i);
        }
        if(max!=i){
            swap(nums, i, max);
            downHeap(nums, max, end);
        }
    }
    private int left(int i){
        return i*2+1;
    }
    private int right(int i){
        return i*2+2;
    }
    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    // Q3.Find K Pairs With Smallest Sums
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap=new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] i1, int[] i2){
                return Integer.compare(i1[0],i2[0]);  // MIN HEAP
            }
        });
        List<List<Integer>> list=new ArrayList<>();
        Set<String> visited=new HashSet<>();
        heap.add(new int[]{nums1[0]+nums2[0], 0, 0});
        while(k>0 && !heap.isEmpty()){
            int[] min=heap.poll();
            int index1=min[1];
            int index2=min[2];
            List<Integer> ans=new ArrayList<>();
            ans.add(nums1[index1]);
            ans.add(nums2[index2]);
            list.add(ans);

            if(index2+1 < nums2.length && !visited.contains(index1+","+(index2+1))){
                heap.add(new int[]{nums1[index1]+nums2[index2+1], index1, index2+1});
                visited.add(index1+","+(index2+1));
            }
            if(index1+1 < nums1.length && !visited.contains((index1+1)+","+index2)){
                heap.add(new int[]{nums1[index1+1]+nums2[index2], index1+1, index2});
                visited.add((index1+1)+","+index2);
            }
            k--;
        }
        return list;
    }

    // Q4.Top K Frequent Elements
    Map<Integer, Integer> map;
    int[][] maxHeap;
    public int[] topKFrequent(int[] nums, int k) {
        // Construct HashMap
        map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        // Construct Array from the HashMap
        int n=map.size();
        maxHeap=new int[n][2];
        int j=0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            maxHeap[j++]=new int[]{entry.getValue(), entry.getKey()};
        }

        // Construct Max-Heap form the Array
        for(int i=(n-1)/2;i>=0;i--){
            downHeap(i, n);   // Max heap is constructed from given array (T.c O(log N)))
        }

        // Get Top k elements from the Max-Heap
        int[] result=new int[k];
        for(int i=0; i<k; i++){
            result[i]=maxHeap[0][1];
            maxHeap[0]=maxHeap[n-1];
            downHeap(0, --n);
        }

        // Return the result
        return result;
    }
    private int getLeft(int i){
        return i*2+1;
    }
    private int getRight(int i){
        return i*+2;
    }

    private void swap(int first, int second){
        int[] temp=maxHeap[first];
        maxHeap[first]=maxHeap[second];
        maxHeap[second]=temp;
    }
    private void downHeap(int i, int end){
        if(getLeft(i)>=end){
            return;
        }
        int max=i;
        if(maxHeap[getLeft(i)][0]>maxHeap[i][0]){
            max=getLeft(i);
        }
        if(getRight(i)<maxHeap.length && maxHeap[getRight(i)][0]>maxHeap[max][0]){
            max=getRight(i);
        }
        if(i!=max){
            swap(i, max);
            downHeap(max, end);
        }
    }

    // Q5.IPO
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if(k==0){
            return w;
        }
        // Construct Min-Heap considering capital.
        // Lower capital should have the higher priority.
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((m, n)->{return m[0]-n[0];});
        for(int i=0; i<capital.length; i++){
            minHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Initialize a Man-Heap considering profit.
        // Higher profit should have the higher priority.
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((m, n)->{return n[1]-m[1];});
        reArrange(maxHeap, minHeap, w);
        while(k>0 && !maxHeap.isEmpty()){
            w+=maxHeap.poll()[1];
            k--;
            reArrange(maxHeap, minHeap, w);
        }
        return w;
    }

    private void reArrange(PriorityQueue<int[]> maxHeap, PriorityQueue<int[]> minHeap, int w){
        while(!minHeap.isEmpty() && minHeap.peek()[0]<=w){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Q6.K Closest Points To Origin
    public int[][] kClosest(int[][] points, int k) {
        // Initialize a Max-Heap
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b)->{return Integer.compare((b[0]*b[0] + b[1]*b[1]), (a[0]*a[0] + a[1]*a[1]));});
        // Construct Max-Heap of size k that contains only k closest elements to origin.
        for(int i=0; i<points.length; i++){
            heap.offer(points[i]);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[][] result=new int[k][2];
        int i=0;
        while(!heap.isEmpty()){
            int[] top=heap.poll();
            result[i]=top;
            i++;
        }
        return result;
    }

    // Q7.Merge K Sorted Lists

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap=new PriorityQueue<>((a, b)->{return a.val-b.val;});
        // Insert First node of all the lists into to the heap
        for(ListNode node: lists){
            if(node!=null) heap.offer(node);
        }

        ListNode head=new ListNode(-1);
        ListNode temp=head;
        while(!heap.isEmpty()){
            ListNode cur=heap.poll();
            if(cur.next!=null){
                heap.offer(cur.next);
            }
            temp.next=cur;
            temp=cur;
        }
        return head.next;
    }

    // Q8.Kth Smallest Element In Sorted Matrix
    public int kthSmallest(int[][] matrix, int k) {
        // pair:{val, row, col}
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b)->{return a[0]-b[0];});
        for(int i=0;i<matrix.length; i++){
            heap.offer(new int[]{matrix[i][0], i, 0});
        }
        int n=matrix.length;
        while(k>1){
            int[] cur=heap.poll();
            int row=cur[1];
            int col=cur[2];
            if(col<n-1){
                ++col;
                heap.offer(new int[]{matrix[row][col], row, col});
            }
            k--;
        }
        return heap.poll()[0];
    }

    // Q9.Task Scheduler
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }

        class Job{
            Character task;
            Integer freq;
            Integer waitingPeriod;
            public Job(){

            }
            public Job(char task, int freq){
                this.task=task;
                this.freq=freq;
                this.waitingPeriod=0;
            }
        }

        // Create a Max Heap to get the task in ready to execute satate and with max frequency.
        PriorityQueue<Job> readyState=new PriorityQueue<>((p, q)->Integer.compare(q.freq, p.freq));

        // Initially all the tasks are in the ready state.
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            Job job=new Job(entry.getKey(), entry.getValue());
            readyState.offer(job);
        }

        // Create a queue to store the tasks in the wait state and maintain the insertion order.
        Queue<Job> waitState=new LinkedList<>();

        // Use a counter to track time of cpu.
        // initially the time is 0;
        int time=0;
        while(true){
            if(readyState.isEmpty() && waitState.isEmpty()){
                break;
            }
            time++;
            // Transfer the tasks from the waiting queue into the Ready State if available
            while(!waitState.isEmpty() && waitState.peek().waitingPeriod<=time){
                readyState.offer(waitState.poll());
            }
            // Execute the task with max freq in the ready state if available and transfer it to wait state.
            if(!readyState.isEmpty()){
                Job cur=readyState.poll();
                if(cur.freq>1){
                    cur.freq--;
                    cur.waitingPeriod=time+n+1;
                    waitState.offer(cur);
                }
            }
        }
        return time;
    }
}
