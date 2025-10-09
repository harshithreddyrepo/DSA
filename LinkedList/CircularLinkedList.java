package DSA_with_kunal.LinkedList;

/*
        head                 tail
         |                    |
         v                    v
     -> [10|*] -> [20|*] -> [30|*] -+
    ^-------------------------------+
*/

public class CircularLinkedList<E> implements LLI<E> {
    private Node<E> head;
    private Node<E> tail;
    public int size;

    class Node<E> {
        private E val;
        private Node<E> next;

        public Node(E data) {
            this.val = data;
        }

        public Node(E data, Node<E> next) {
            this.val = data;
            this.next = next;
        }
    }

    @Override
    public void insert(E val) {
        Node<E> node = new Node<>(val);
        if (head == null) {
            head = node;
            tail = node;
            node.next = node;
            size++;
            return;
        }
        if (head == tail) {
            head.next = node;
            node.next = head;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    @Override
    public void insertFirst(E val) {
        Node<E> node = new Node<>(val);
        if (head == null) {
            head = node;
            tail = node;
            node.next = node;
            size++;
            return;
        }
        if (head == tail) {
            node.next = head;
            head.next = node;
            head = node;
            size++;
            return;
        }
        node.next = head;
        tail.next = node;
        head = node;
        size++;
        return;
    }

    @Override
    public void insertLast(E val) {
        Node<E> node = new Node<>(val);
        if (head == null) {
            head = node;
            tail = node;
            node.next = node;
            size++;
            return;
        }
        if (head == tail) {
            head.next = node;
            node.next = head;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    @Override
    public boolean insertAt(int index, E val) {
        if (index < 0) {
            return false;
        }
        Node<E> node = new Node<>(val);
        if (index == 0) {
            insertFirst(val);
            return true;
        }
        if (head == null) {
            return false;
        }
        index = index % size;
        if (index == 0) {
            insertLast(val);
            return true;
        }
        Node<E> temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
        return true;
    }

    @Override
    public E deleteFirst() {
        if (head == null) {
            return null;
        }
        E val = head.val;
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return val;
        }
        head = head.next;
        tail.next = head;
        size--;
        return val;
    }

    @Override
    public E deleteLast() {
        if (head == null) {
            return null;
        }
        E val = tail.val;
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return val;
        }
        Node<E> temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        temp.next = head;
        size--;
        return val;
    }

    @Override
    public E delete(int index) {
        if (head == null) {
            return null;
        }
        if (index < 0) {
            return null;
        }
        if (index == 0) {
            return deleteFirst();
        }
        index = index % size;
        if (index == 0) {
            return deleteLast();
        }
        Node<E> temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        E val = temp.next.val;
        temp.next = temp.next.next;
        size--;
        return val;
    }

    @Override
    public boolean delete(E val) {
        if (head == null) {
            return false;
        }
        if (head.val.equals(val)) {
            deleteFirst();
            return true;
        }
        if (tail.val.equals(val)) {
            deleteLast();
            return true;
        }
        Node<E> temp = head;
        while (temp.next != head && !temp.next.val.equals(val)) {
            temp = temp.next;
        }
        if (temp == tail) {
            return false;
        }
        temp.next = temp.next.next;
        size--;
        return true;
    }

    @Override
    public E update(int index, E val) {
        if (head == null) {
            return null;
        }
        if (index < 0) {
            return null;
        }
        index = index % size;
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        E preVal = temp.val;
        temp.val = val;
        return preVal;
    }

    @Override
    public boolean search(E val) {
        if (head == null) {
            return false;
        }
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.val.equals(val)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (head == null || index < 0) {
            return null;
        }
        index = index % size;
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    @Override
    public void display() {
        if (head == null) {
            System.out.println("Empty!");
            return;
        }
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End!");
    }
}
