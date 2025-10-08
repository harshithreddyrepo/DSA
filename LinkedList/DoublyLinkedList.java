package DSA_with_kunal.LinkedList;

/*
    NULL <- [10|*] <-> [20|*] <-> [30|*] -> NULL
              ^                     ^
              |                     |
             head                  tail
 */

public class DoublyLinkedList<E> implements LLI<E> {
    private Node<E> head;  // head=null
    private Node<E> tail;  // tail=null;
    public int size;

    class Node<E> {

        private Node<E> prev;
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void insert(E data) {
        Node<E> node = new Node<>(data);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void insertFirst(E data) {
        Node<E> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public void insertLast(E data) {
        Node<E> node = new Node<>(data);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public boolean insertAt(int index, E data) {
        if (index < 0 && -1 * index <= size) {
            index = size + index;
        }
        if (index == 0) {
            insertFirst(data);
            return true;
        }
        if (index == size) {
            insertLast(data);
            return true;
        }
        if (index > size || index < 0) {
            return false;
        }
        Node<E> node = new Node<>(data);
        Node<E> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        node.prev = temp;
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        size++;
        return true;
    }

    @Override
    public E deleteFirst() {
        if (head == null) {
            return null;
        }
        E data = head.data;
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return data;
        }
        head = head.next;
        head.prev = null;
        size--;
        return data;
    }

    @Override
    public E deleteLast() {
        if (tail == null) {
            return null;
        }
        E data = tail.data;
        if (tail == head) {
            tail = null;
            head = null;
            size--;
            return data;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
        return data;
    }

    @Override
    public E delete(int index) {
        if (index < 0 && -1 * index <= size) {
            index = size + index;
        }
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        if (index >= size || index < 0 || head == null) {
            return null;
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
        return temp.data;
    }

    @Override
    public boolean delete(E data) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(data)) {
            deleteFirst();
            return true;
        }
        if (tail.data.equals(data)) {
            deleteLast();
            return true;
        }
        Node<E> temp = head;
        while (temp != null && !temp.data.equals(data)) {
            temp = temp.next;
        }
        if (temp == null) {
            return false;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
        return true;
    }

    @Override
    public E update(int index, E data) {
        if (head == null) {
            return null;
        }
        if (index < 0 && -1 * index <= size) {
            index = size + index;
        }
        if (index >= size || index < 0) {
            return null;
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        E oldData = temp.data;
        temp.data = data;
        return oldData;
    }

    @Override
    public boolean search(E data) {
        if (head == null) {
            return false;
        }
        Node<E> temp = head;
        while (temp != null && !temp.data.equals(data)) {
            temp = temp.next;
        }
        if (temp == null) {
            return false;
        }
        return true;
    }

    @Override
    public E get(int index) {
        if (head == null) {
            return null;
        }
        if (index < 0 && -1 * index <= size) {
            index = size + index;
        }
        if (index >= size || index < 0) {
            return null;
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public void display() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
        }
        System.out.println("null");
    }
}
