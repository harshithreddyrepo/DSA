package DSA_with_kunal.TreeDataStructure;

public class AVL {
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

    private Node root;

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
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
        return rotate(node);
    }

    protected Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){
            // Left heavy
            if(height(node.left.left)>height(node.left.right)){  
                // Case 1: Left-Left
                return rightRotate(node);
            }
                // Case 2: Left-Right
                node.left=leftRotate(node.left);
                return rightRotate(node);
        }
        if(height(node.right)-height(node.left)>1){
            // Right heavy
            if(height(node.right.right)>height(node.right.left)){
                // Case 3: Right-Right
                return leftRotate(node);
            }
                // Case 4: Right-Left
                node.right=rightRotate(node.right);
                return leftRotate(node);
        }
        return node;
    }

    private Node leftRotate(Node node) {
        // 1.Adjust the pointer
        Node child=node.right;
        Node temp=child.left;
        // 2.Perform the rotation
        child.left=node;
        node.right=temp;
        // 3.Recalculate heights(Bottom-up i.e, update the node first then update child)
        node.height=Math.max(height(node.right),height(node.left))+1;
        child.height=Math.max(height(child.left),height(child.right))+1;

        return child;
    }

    private Node rightRotate(Node node) {
        // 1.Adjusting the pointer
        Node child=node.left;
        Node temp=child.right;
        // 2. Perform rotation
        child.right=node;
        node.left=temp;
        // 3.Recalculate heights(Bottom-up  i.e, update the node first then update child)
        node.height=Math.max(height(node.right),height(node.left))+1;
        child.height=Math.max(height(child.left),height(child.right))+1;

        return child;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
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
