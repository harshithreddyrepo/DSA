package DSA_with_kunal.Patterns.TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

    }
    /*
    Q1. Find Median From Data Stream
    =>The median is the middle value in an ordered integer list. If the size of the list
     is even, there is no middle value, and the median is the mean of the two middle values.
     */
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
}
