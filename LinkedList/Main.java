package DSA_with_kunal.LinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll=new SinglyLinkedList<>();

        sll.insert(10);
        sll.insert(20);
        sll.insert(30);
        sll.insert(40);
        System.out.println(sll.size);
       sll.update(2,33);
       sll.display();
        System.out.println(sll.search(33));


    }
}
