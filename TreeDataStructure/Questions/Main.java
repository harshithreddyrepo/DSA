package DSA_with_kunal.TreeDataStructure.Questions;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /*
     Q1. Binary Tree Level Order Traversal
     => Given the root of a binary tree, return the level order traversal of its nodes' values.
        (i.e., from left to right, level by level).
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return  new ArrayList<>();
        }
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> currentLevel=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode current=queue.poll();
                currentLevel.add(current.val);
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    /*
     Q2. Average Of Levels In Binary Tree
     =>Given the root of a binary tree, return the average value of the nodes on each level in
      the form of an array. Answers within 10-5 of the actual answer will be accepted.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            Double sum=0.0;
            for(int i=0;i<levelSize;i++){
                TreeNode current=queue.poll();
                sum+=current.val;
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
            result.add(sum/levelSize);
        }
        return result;
    }

    /*
     Q3. Level Order Successor Of a Node In Binary Tree

     */
    public TreeNode findSuccessor(TreeNode root, TreeNode key){
        if (root == null) return null;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode current=queue.poll();
            if(current.left!=null) queue.offer(current.left);
            if(current.right!=null) queue.offer(current.right);
            if(current.val==key.val){
                return queue.peek();
            }
        }
        return null;
    }

    /*
     Q4. Binary Tree ZigZag Level Order Traversal
     => Given the root of a binary tree, return the zigzag level order traversal
        of its nodes' values. (i.e., from left to right, then right to left for the
        next level and alternate between).
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> result=new ArrayList<>();
        Boolean flag=true;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> currentLevel=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                if(flag){
                    TreeNode current=queue.poll();
                    currentLevel.add(current.val);
                    if(current.left!=null) queue.offer(current.left);
                    if(current.right!=null) queue.offer(current.right);
                }else{
                    TreeNode current=queue.pollLast();
                    currentLevel.add(current.val);
                    if(current.right!=null) queue.offerFirst(current.right);
                    if(current.left!=null) queue.offerFirst(current.left);
                }
            }
            result.add(currentLevel);
            flag=!flag;
        }
        return result;
    }

    /*
     Q5. Binary Tree Level Order Traversal II
     => Given the root of a binary tree, return the bottom-up level order traversal of its
        nodes' values. (i.e., from left to right, level by level from leaf to root).
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> currentLevel=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode current=queue.poll();
                currentLevel.add(current.val);
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
            result.addFirst(currentLevel);
        }
        return result;
    }

    /*
     Q6. Populating Next Right Pointers In Each Node
     => You are given a perfect binary tree where all leaves are on the same level,
        and every parent has two children. The binary tree has the following definition:

         struct Node {
           int val;
           Node *left;
           Node *right;
           Node *next;
         }
       Populate each next pointer to point to its next right node. If there is no next right node,
       the next pointer should be set to NULL.

       Initially, all next pointers are set to NULL.
     */
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            Node neighbour=null;
            for(int i=0;i<levelSize;i++){
                Node current=queue.poll();
                current.next=neighbour;
                neighbour=current;
                if(current.right!=null) queue.offer(current.right);
                if(current.left!=null) queue.offer(current.left);
            }
        }
        return root;
    }
}
