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
         // ** BFS(Breadth-First-Search)  **\\
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
        preorderHelper(root);
        return root;
    }
    public void preorderHelper(Node node){
        if(node.left==null){
            return;
        }
        Node temp=node;
        while(temp!=null){
            temp.left.next=temp.right;
            if(temp.next!=null) temp.right.next=temp.next.left;
            temp=temp.next;
        }
        preorderHelper(node.left);
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

           //  ** DFS(Depth-First-Search) **  \\
    /*
     Q10. Binary Tree Diameter
     =>Given the root of a binary tree, return the length of the diameter of the tree.

       The diameter of a binary tree is the length of the longest path between any two nodes
       in a tree. This path may or may not pass through the root.

       The length of a path between two nodes is represented by the number of edges between them.
     */
           int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diaHelper(root);
        return dia;
    }
    public int diaHelper(TreeNode node){
        if(node==null){
            return -1;
        }
        int left=diaHelper(node.left);
        int right=diaHelper(node.right);
        dia=Math.max(dia,left+right+2);
        return Math.max(left,right)+1;
    }

    /*
     Q11. Invert Binary Tree
     =>Given the root of a binary tree, invert the tree, and return its root.
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }


    /*
     Q12. Maximum Depth of Binary Tree
     =>Given the root of a binary tree, return its maximum depth.

       A binary tree's maximum depth is the number of nodes along the longest path
       from the root node down to the farthest leaf node.
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /*
     Q13. Convert Sorted Array To Binary Search Tree
     =>Given an integer array nums where the elements are sorted in ascending order,
       convert it to a height-balanced binary search tree.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayHelper(nums, 0, nums.length);
    }
    public TreeNode sortedArrayHelper(int[] nums, int start, int end){
        if(start==end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode left=sortedArrayHelper(nums, start, mid);
        TreeNode right=sortedArrayHelper(nums, mid+1, end);
        TreeNode node=new TreeNode(nums[mid], left, right);
        return node;
    }

    /*
     Q14. Flatten Binary Tree to LinkedList
     =>Given the root of a binary tree, flatten the tree into a "linked list":

       The "linked list" should use the same TreeNode class where the right child pointer
       points to the next node in the list and the left child pointer is always null.

       The "linked list" should be in the same order as a pre-order traversal of the binary tree.
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null){
            flatten(root.right);
        }else{
            TreeNode right=root.right;
            root.right=root.left;
            rightMost(root).right=right;
            root.left=null;
            flatten(root.right);
        }
    }
    public TreeNode rightMost(TreeNode node){
        if(node.right==null){
            return node;
        }
        return rightMost(node.right);
    }

    /*
     Q15. Validate Binary Search Tree
     =>Given the root of a binary tree, determine if it is a valid binary search tree (BST).

       A valid BST is defined as follows:

        i.The left subtree of a node contains only nodes with keys strictly less than the node's key.
       ii.The right subtree of a node contains only nodes with keys strictly greater than the node's key.
      iii.Both the left and right subtrees must also be binary search trees.
     */
    public boolean isValidBST(TreeNode root) {
        Integer ll=null;
        Integer rl=null;
        return validateHelper(root, ll, rl);
    }
    public boolean validateHelper(TreeNode node, Integer ll, Integer rl){
        if(node==null){
            return true;
        }
        if((ll!=null && node.val<=ll) || (rl!=null && node.val>=rl)){
            return false;
        }
        if((node.left!=null && node.left.val>=node.val) || (node.right!=null && node.right.val<=node.val)){
            return false;
        }
        return validateHelper(node.left, ll, node.val) && validateHelper(node.right, node.val, rl);
    }

    /*
     Q16. Lowest Common Ancestor
     =>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

       According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
       two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a
       node to be a descendant of itself).”
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        return right;
    }

    /*
     Q17. Kth Smallest Element in BST
     =>Given the root of a binary search tree, and an integer k, return the kth smallest value
      (1-indexed) of all the values of the nodes in the tree.
     */
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        int left=kthSmallest(root.left,k);
        if(left!=-1){
            return left;
        }
        count++;
        if(count==k){
            return root.val;
        }
        return kthSmallest(root.right,k);
    }

    /*
     Q18. Construct Binary Tree form Preorder and Inorder Traversal
     =>Given two integer arrays preorder and inorder where preorder is the preorder traversal of
      a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
     */
    int p=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return preorderHelper(preorder, inorder, 0, inorder.length);
    }
    public TreeNode preorderHelper(int[] preorder, int[] inorder, int low, int high){
        if(low==high){
            return null;
        }
        TreeNode node=new TreeNode(preorder[p]);

        // find the index of node value in inorder.
        int i=low;
        while(inorder[i]!=preorder[p]){
            i++;
        }
        p++;
        node.left= preorderHelper(preorder, inorder, low, i);
        node.right= preorderHelper(preorder, inorder, i+1, high);
        return node;
    }

    /*
     Q19. Serialize and Deserialize Binary Tree
     =>Serialization is the process of converting a data structure or object into a sequence
      of bits so that it can be stored in a file or memory buffer, or transmitted across a
      network connection link to be reconstructed later in the same or another computer environment.

      Design an algorithm to serialize and deserialize a binary tree. There is no restriction
      on how your serialization/deserialization algorithm should work. You just need to ensure
      that a binary tree can be serialized to a string and this string can be deserialized to the
      original tree structure.
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        String left=seHelper(root.left, new StringBuilder()).toString();
        String right=seHelper(root.right, new StringBuilder()).toString();
        return root.val+left+right;
    }
    private StringBuilder seHelper(TreeNode node, StringBuilder serialize){
        if(node==null){
            serialize.append(",*");
            return serialize;
        }
        StringBuilder cur=serialize.append(","+node.val);
        StringBuilder left=seHelper(node.left, cur);
        return seHelper(node.right, left);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null){
            return null;
        }
        String[] arr=data.split(",");
        return deHelper(arr);
    }
    int i=0;
    private TreeNode deHelper(String[] arr){
        if(arr[i].equals("*")){
            i++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(arr[i]));
        i++;
        node.left=deHelper(arr);
        node.right=deHelper(arr);
        return node;
    }

    /*
     Q20. Path Sum
     =>Given the root of a binary tree and an integer targetSum, return true if the tree has
      a root-to-leaf path such that adding up all the values along the path equals targetSum.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return targetSum-root.val==0;
        }

        boolean left=hasPathSum(root.left, targetSum-root.val);
        if(left){
            return left;
        }
        return hasPathSum(root.right, targetSum-root.val);
    }

    /*
    Q21. Sum Root to Leaf Numbers
    =>You are given the root of a binary tree containing digits from 0 to 9 only.

      Each root-to-leaf path in the tree represents a number.

      For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
      Return the total sum of all root-to-leaf numbers. Test cases are generated so that
      the answer will fit in a 32-bit integer.

      A leaf node is a node with no children.
     */
    public int sumNumbers(TreeNode root) {
        return sumNumberHelper(root, 0);
    }
    public int sumNumberHelper(TreeNode node, int val){
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right==null){
            return val*10+node.val;
        }
        return sumNumberHelper(node.left,val*10+node.val)+ sumNumberHelper(node.right,val*10+node.val) ;
    }

    /*
     Q22. Binary Tree Maximum Path Sum
     =>A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in
       the sequence has an edge connecting them. A node can only appear in the sequence at
       most once. Note that the path does not need to pass through the root.

       The path sum of a path is the sum of the node's values in the path.

       Given the root of a binary tree, return the maximum path sum of any non-empty path.
     */
    int maxPathSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxPathSum;
    }

    public int maxPathSumHelper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left= maxPathSumHelper(node.left);
        int right= maxPathSumHelper(node.right);

        // Filter the nodes that contribute to reduce the path sum.
        left=Math.max(0,left);
        right=Math.max(0,right);

        int pathSum=node.val+left+right;
        maxPathSum=Math.max(maxPathSum, pathSum);
        return left>right?node.val+left:node.val+right;
    }

    /*
     Q23. Path Sum III
     =>Given the root of a binary tree and an integer targetSum, return the number of paths
       where the sum of the values along the path equals targetSum.

      The path does not need to start or end at the root or a leaf, but it must go downwards
      (i.e., traveling only from parent nodes to child nodes).
     */
    int pathSumCount=0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> pathSum=new HashMap<>();
        pathSum.put(0l,1);
        helper(root, pathSum, 0l, targetSum);
        return pathSumCount;
    }
    private void helper(TreeNode node, Map<Long ,Integer> pathSum, Long prefixSum, int target){
        if(node==null){
            return;
        }
        Long sum=prefixSum+node.val;
        if(pathSum.containsKey(sum-target)){
            count+=pathSum.get(sum-target);
        }
        pathSum.put(sum,pathSum.getOrDefault(sum,0)+1);
        helper(node.left,pathSum, sum, target);
        helper(node.right,pathSum, sum, target);
        if(pathSum.get(sum)==1){
            pathSum.remove(sum);
            return;
        }
        pathSum.put(sum,pathSum.get(sum)-1);
    }
}
