package DSA_with_kunal.TreeDataStructure;

public class Main {
    public static void main(String[] args) {
//        BinaryTree bt=new BinaryTree();
//        bt.populate();
//        bt.display();
//        bt.prettyDisplay();
//        BinarySearchTree bst=new BinarySearchTree();
//       // bst.populate(new int[]{10,6,15,9,13,23});
//        bst.sortedPopulate(new int[]{1,2,3,4,5,6,7,8,9,10});
//       // bst.prettyDisplay();
//        bst.preOrder();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
////        bst.postOrder();
//        AVL avl=new AVL();
//        avl.populate(new int[]{1,2,3,4,5,6,7,8,9,10});
//        avl.prettyDisplay();
//        System.out.println(avl.balanced());
        SegmentTree st=new SegmentTree(new int[]{3,8,7,6,-2,-8,4,9});
        int sum=st.findSumOfRange(0,7);
        System.out.println(sum);
        st.update(4,0);
        sum=st.findSumOfRange(0,7);
        System.out.println(sum);
    }
}
