package DSA_with_kunal.TreeDataStructure.BinaryTreeAlgorithmsForTechnicalInterviews;

import DSA_with_kunal.TreeDataStructure.BinaryTree;

import java.util.*;

public class Algorithms {
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
          // ** DFS(Depth-First-Search) ** \\
    // 1. Iterative approach (explicit stack):
    public static List<Integer> depthFirstSearchItr(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node current=stack.pop();
            result.add(current.value);
            if(current.right!=null) stack.push(current.right);
            if(current.left!=null) stack.push(current.left);
        }
        return result;
    }
    // 2. Recursive approach (implicit stack):
    public static List<Integer> depthFirstSearchRec(Node node){
        if(node==null) return new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        result.add(node.value);
        List<Integer> left=depthFirstSearchRec(node.left);
        result.addAll(left);
        List<Integer> right=depthFirstSearchRec(node.right);
        result.addAll(right);
        return result;
    }
    /*
     Take-away: The Space can be optimized
       =>The space can be optimized by avoiding the creation of a new ArrayList in every recursive call.
         In the given recursive DFS implementation, each call creates its own ArrayList and later merges
         child lists using addAll(), which causes unnecessary object creation and memory overhead. Instead,
         we can pass a single result list through all recursive calls and keep adding node values to it,
         thereby reducing object creation and improving space efficiency.
     */

                 // ** BFS(Breadth-First-Search) ** \\
    public static List<Integer> breadthFirstSearch(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
        Queue<Node> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node current=queue.poll();
            result.add(current.value);
            if(current.left!=null) queue.offer(current.left);
            if(current.right!=null) queue.offer(current.right);
        }
        return result;
    }
}
