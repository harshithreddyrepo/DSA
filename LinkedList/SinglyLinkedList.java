package DSA_with_kunal.LinkedList;

/*
    Head -> [10|*] -> [20|*] -> [30|*] -> NULL
              ^                  ^
              |                  |
             head               tail
*/

public class SinglyLinkedList <E> implements LLI <E>{
    private Node head;  // head=null
    private Node tail;  // tail=null;
    private class Node <E>{
        private E data;
        private Node next;
        public Node(E data) {
            this.data = data;
        }
        public Node(E data, Node next) {
            this.data=data;
            this.next=next;
        }
    }
    @Override
    public void insert(E object) {
        Node<E> node=new Node<>(object,null);
        if(tail==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
    }

    @Override
    public void insertFirst(E object) {
        Node<E> node=new Node<>(object);
        if(head==null){
            head=node;
            tail=node;
        }else{
            node.next=head;
            head=node;
        }
    }

    @Override
    public void insertLast(E object) {
        Node<E> node=new Node<>(object,null);
        if(tail==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
    }

    @Override
    public boolean insertAt(int index, E object) {
       if(index==0){
           insertFirst(object);
           return true;
       }
        Node<E> node=new Node<>(object);
       Node<E> temp=head;
       while(temp!=null && index>1){
           temp=temp.next;
           index--;
       }
       if(temp==null){
           return false;
       }
       node.next=temp.next;
       temp.next=node;
       return true;
    }

    @Override
    public E deleteFirst() {
        if(head==null){
            return null;
        }
        Node<E> temp=head;
        head=head.next;
        return temp.data;
    }

    @Override
    public E deleteLast() {
        return null;
    }

    @Override
    public E delete(int index) {
        return null;
    }

    @Override
    public boolean delete(E object) {
        return false;
    }

    @Override
    public boolean search(E object) {
        return false;
    }

    @Override
    public void display() {

    }
}
