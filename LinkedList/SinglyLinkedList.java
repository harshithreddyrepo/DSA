package DSA_with_kunal.LinkedList;

/*
    Head -> [10|*] -> [20|*] -> [30|*] -> NULL
              ^                  ^
              |                  |
             head               tail
*/

public class SinglyLinkedList <E> implements LLI <E>{
    private Node<E> head;  // head=null
    private Node<E> tail;  // tail=null;
    public int size;

    private class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data) {
            this.data = data;
        }
        public Node(E data, Node<E> next) {
            this.data=data;
            this.next=next;
        }
    }
    @Override
    public void insert(E data) {
        Node<E> node=new Node<>(data);
        if(tail==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
        size++;
    }

    @Override
    public void insertFirst(E data) {
        Node<E> node=new Node<>(data);
        if(head==null){
            head=node;
            tail=node;
        }else{
            node.next=head;
            head=node;
        }
        size++;
    }

    @Override
    public void insertLast(E data) {
        Node<E> node=new Node<>(data);
        if(tail==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
        size++;
    }

    @Override
    public boolean insertAt(int index, E data) {
       if(index==0){
           insertFirst(data);
           return true;
       }
       if(index==size){
           insertLast(data);
           return true;
       }
       if(index>size || index<0){
           return false;
       }
       Node<E> node=new Node<>(data);
       Node<E> temp=head;
       while(index>1){
           temp=temp.next;
           index--;
       }
       node.next=temp.next;
       temp.next=node;
       size++;
       return true;
    }

    @Override
    public E deleteFirst() {
        if(head==null){
            return null;
        }
        E data=head.data;
        head=head.next;
        size--;
        return data;
    }

    @Override
    public E deleteLast() {
        if(head==null){
            return null;
        }
        if (head == tail) {
            E data = head.data;
            head = tail = null;
            size--;
            return data;
        }
        Node<E> temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        E data=tail.data;
        tail=temp;
        tail.next=null;
        size--;
        return data;
    }

    @Override
    public E delete(int index) {
        if(index>=size || index<0){
            return null;
        }
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node<E> temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        E data=temp.next.data;
        temp.next=temp.next.next;
        size--;
        return data;
    }

    @Override
    public boolean delete(E data) {
        if(head==null){
            return false;
        }
        if(head.data.equals(data)){
            deleteFirst();
            return true;
        }
        if(tail.data.equals(data)){
            deleteLast();
            return true;
        }
        Node<E> temp=head;
        while(temp.next!=null && !temp.next.data.equals(data) ){
            temp=temp.next;
        }
        if(temp.next != null && temp.next.data.equals(data)){
            temp.next=temp.next.next;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public E update(int index, E data) {
        if(index>=size || index<0){
            return null;
        }
        Node<E> temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        E prev=temp.data;
        temp.data=data;
        return prev;
    }

    @Override
    public boolean search(E data) {
        if(head==null){
            return false;
        }
        Node<E> temp=head;
        while(temp!=null && temp.data!=data){
            temp=temp.next;
        }
        return temp != null;
    }

    @Override
    public void display() {
        if(head==null){
            return;
        }
        Node<E> temp=head;
        while(temp!=null){
            System.out.print(temp.data.toString()+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
