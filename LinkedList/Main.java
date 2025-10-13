package DSA_with_kunal.LinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll=new SinglyLinkedList<>();
        sll.insertLast(3);
        sll.insertLast(5);
        sll.insertLast(9);
        sll.insertLast(1);

        sll.insertRec(3,7);
        sll.insertRec(0,4);

        sll.display();
    }
}
