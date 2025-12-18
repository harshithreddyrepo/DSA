package DSA_with_kunal.TreeDataStructure;

import java.util.Scanner;

public class BinarySearchTree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;
        int height;

        Node() {

        }

        Node(int value) {
            this.value = value;
        }
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void populate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root node:");
        root = new Node(sc.nextInt());
        System.out.println("Do you want to insert a node:");
        boolean status = sc.nextBoolean();
        while (status) {
            System.out.println("Enter the value:");
            Node newNode = new Node(sc.nextInt());
            populate(root, newNode);
            System.out.println("Do you want to insert a node:");
            status = sc.nextBoolean();
        }
    }

    private void populate(Node node, Node newNode) {
        if (newNode.value > node.value) {
            if (node.right == null) {
                node.right = newNode;
            } else {
                populate(node.right, newNode);
            }
        }
        if(newNode.value < node.value){
            if (node.left == null) {
                node.left = newNode;
            } else {
                populate(node.left, newNode);
            }
        }
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    public Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.value) {
            node.left = insert(node.left, val);
        } 
        if(val > node.value){
            node.right = insert(node.right, val);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(node.left.height - node.right.height) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display(root, "Root node:");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "left child of " + node.value + ":");
        display(node.right, "right child of  " + node.value + ":");
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
    }


    void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level == 0) {
            System.out.println(node.value);
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

    public void sortedPopulate(int nums[]){
        sortedPopulate(nums,0,nums.length);
    }

    private void sortedPopulate(int[] nums, int start, int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        insert(nums[mid]);
        sortedPopulate(nums, start, mid);
        sortedPopulate(nums, mid+1, end);
    }

    // **Traversal Methods** //
    // 1.Pre-Order Traversal
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.value+", "); // Node
        preOrder(node.left); // Left
        preOrder(node.right); // Right
    }
    // 2.In-Order Traversal
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+", ");
        inOrder(node.right);
    }
    // 3.Post-Order Traversal
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+", ");
    }
}
