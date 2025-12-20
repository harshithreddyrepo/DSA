package DSA_with_kunal.TreeDataStructure.Questions;

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
    // Iterative approach(Using Explicit Queue)
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
    // Recursive approach(Using Implicit Stack)
    public Node connectRec(Node root) {
        if(root==null){
            return null;
        }
        helper(root);
        return root;
    }
    public void helper(Node node){
        if(node.left==null){
            return;
        }
        Node temp=node;
        while(temp!=null){
            temp.left.next=temp.right;
            if(temp.next!=null) temp.right.next=temp.next.left;
            temp=temp.next;
        }
        helper(node.left);
    }

    /*
     Q7. Binary Tree Right Side View
     =>Given the root of a binary tree, imagine yourself standing on the right side of it,
       return the values of the nodes you can see ordered from top to bottom.
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            result.add(queue.peek().val);
            for(int i=0;i<levelSize;i++){
                TreeNode current=queue.poll();
                if(current.right!=null) queue.offer(current.right);
                if(current.left!=null) queue.offer(current.left);
            }
        }
        return result;
    }

    /*
     Q8. Cousins In Binary Tree
     =>Given the root of a binary tree with unique values and the values of two different nodes
       of the tree x and y, return true if the nodes corresponding to the values x and y in the
       tree are cousins, or false otherwise.

       Two nodes of a binary tree are cousins if they have the same depth with different parents.

       Note that in a binary tree, the root node is at the depth 0, and children of each depth k
       node are at the depth k + 1.
     */
   // Iterative approach(Using Explicit Queue)
    public boolean isCousinsItr(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundX = false;
        boolean foundY = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            foundX = false;
            foundY = false;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.val == x) foundX = true;
                if (current.val == y) foundY = true;
                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y) || (current.left.val == y && current.right.val == x)) {
                        return false;
                    }
                }
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            if (foundX && foundY) return true;
        }
        return false;
    }
    // Recursive approach(Using Implicit Stack)
    public boolean isCousinRec(TreeNode root, int x, int y){
        TreeNode xx=findNode(root, x); // Find the x node in the tree.
        TreeNode yy=findNode(root, y); // Find the y node in the tree.
        int xDepth=findDepth(root, xx, 0); // Find the depth of xx node.
        int yDepth=findDepth(root, yy, 0); // Find the depth of yy node.

//        if(xDepth==yDepth){ // Check whether xx and yy are at same level.
//            return !isSibling(root, xx, yy); // Check whether xx and yy are siblings(children of same parent).
//        }
//        return false;

        return (xDepth==yDepth)&&(!isSibling(root, xx, yy));
    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if(node == null){
            return false;
        }
        return (node.left==x && node.right==y) || (node.right==x && node.left==y) || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }

    private int findDepth(TreeNode node, TreeNode x, int lev) {
        if(node==null){ // End of the path.
            return 0;
        }
        if(node==x){
            return lev+1; // Returns the level of current node.
        }
        int l=findDepth(node.left, x, lev+1); // Check for the node in left subtree, return the level if exists.
        if(l!=0){
            return l;
        }
        return findDepth(node.right, x, lev+1); // Check for the node in right subtree, return the level if exists.
    }

    private TreeNode findNode(TreeNode node, int key) {
        if(node==null){ // End of the path is reached.
            return null;
        }
        if(node.val==key){  // Check whether the current node is desired node.
            return node;
        }
        TreeNode left=findNode(node.left,key); // Check for the node in left subtree and return if exists.
        if(left!=null) return left;
        return findNode(node.right, key); // Check for the node in right subtree and return if exists.
    }

    /*
     Q9. Symmetric Tree
     =>Given the root of a binary tree, check whether it is a mirror of itself
       (i.e., symmetric around its center).
     */
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode left=queue.poll();
                TreeNode right=queue.poll();
                if((left==null && right!=null) || (left!=null && right==null)) return false;
                if(left != null){
                    if(left.val!=right.val) return false;
                    queue.offer(left.left);
                    queue.offer(right.right);
                    queue.offer(left.right);
                    queue.offer(right.left);
                }
            }
        }
        return true;
    }
}
