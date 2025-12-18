package DSA_with_kunal.TreeDataStructure;

import java.util.Scanner;

public class BinaryTree {
    private Node root;
    class Node{
        int value;
        Node left;
        Node right;
        public Node(){

        }
        public Node(int value){
            this.value=value;
        }
    }
    public BinaryTree(){

    }
    public  void populate(){
        Scanner sc=new Scanner(System.in);
        root=new Node();
        System.out.println("Enter the root node:");
        int val=sc.nextInt();
        root.value=val;
        populate(root,sc);
    }

    private void populate(Node node, Scanner sc) {
        System.out.println("Do you want to enter the value left to "+node.value);
        boolean  left=sc.nextBoolean();
        if(left){
            Node leftNode=new Node();
            System.out.println("Enter the value:");
            int val=sc.nextInt();
            leftNode.value=val;
            node.left=leftNode;
            populate(leftNode,sc);
        }
        System.out.println("Do you want to enter the value right to "+node.value);
        boolean  right=sc.nextBoolean();
        if(right){
            Node rightNode=new Node();
            System.out.println("Enter the value:");
            int val=sc.nextInt();
            rightNode.value=val;
            node.right=rightNode;
            populate(rightNode,sc);
        }
    }

    void display(){
        display(this.root,"");
    }
    void display(Node node, String indent){
        if(node==null){
            System.out.println(indent+"null");
            return;
        }
        System.out.println(indent+node.value);
        display(node.left, indent+"\t");
        display(node.right,indent+"\t");
    }

    void prettyDisplay(){
        prettyDisplay(root,0);
    }

    private void prettyDisplay(Node node, int level) {
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level==0){
            System.out.println(node.value);
        }else{
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+node.value);
        }
        prettyDisplay(node.left,level+1);
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
