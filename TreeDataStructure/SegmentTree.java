package DSA_with_kunal.TreeDataStructure;
/*
  A Segment Tree is a binary tree data structure used for answering range queries and updating elements efficiently.
    It is mainly used when you repeatedly need to do:
     1.Range Queries:
       Example → sum of a range, minimum in a range, maximum in a range, gcd of a range, etc.
     2.Point or Range Updates:
       Modify a value in the array (or a whole range), and efficiently update the result.
 */
// Let's create a segment tree to solve sum of range problem.
public class SegmentTree {
  /*
   Every node should contain two components:
    1. range or interval
    2. sum of range
   */
    class Node{
        int[] interval;
        int sum;
        Node left;
        Node right;

        public Node(){
           this.interval= new int[]{-1, -1};
           this.sum=0;
        }
        public Node(int start, int end){
            this.interval=new int[]{start,end};
        }
        public Node(int start, int end, int sum){
            this.interval=new int[]{start,end};
            this.sum=sum;
        }
    }
    Node root;
    public SegmentTree(int[] nums){
        root=populate(nums,0,nums.length-1);
    }
    private Node populate(int[] nums, int start, int end) {
        if(start==end){
            return new Node(start, start, nums[start]);
        }
        Node node=new Node(start, end);
        int mid=start+(end-start)/2;
        node.left=populate(nums, start, mid);
        node.right=populate(nums, mid+1, end);
        node.sum=node.left.sum+node.right.sum;
        return node;
    }

    public int findSumOfRange(int start, int end){
        return findSumOfRange(root, start, end);
    }
    private int findSumOfRange(Node node, int start, int end){
        // Case  1: No Overlap -> return 0
        if(node.interval[0]>end || node.interval[1]<start){
            return 0;
        }
        // Case 2: Complete Overlap -> return sum
        if(node.interval[0]==node.interval[1]){
            return node.sum;
        }
        //Case 3: Partial Overlap -> Go for the next level
        return findSumOfRange(node.left, start, end)+findSumOfRange(node.right, start, end);
    }

    public void update(int index, int val){
        root.sum=update(root, index, val);
    }
    private int update(Node node, int index, int val){
        if(node.interval[0]==index && node.interval[1]==index){
            node.sum=val;
            return node.sum;
        }
        if(node.interval[1]<index || node.interval[0]>index){
            return node.sum;
        }
        return update(node.left, index, val) + update(node.right, index, val);
    }
}
