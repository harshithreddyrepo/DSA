package DSA_with_kunal.LinkedList;
/*
  => Functionalities:
     1.Insert
     -> void insertFirst(E object)
     -> void insertLast(E object) or insert(E object)
     -> void insertAt(int index, E object)
     2.Delete
     -> E deleteFirst()
     -> E  deleteLast() or delete()
     -> E delete(int index)
     -> boolean delete(E object)
     3.Search
     -> boolean search(E object)
     4.display
     -> void display()
*/
public interface LLI<E> {
    // INSERT
    void insert(E object);
    void insertFirst(E object);
    void insertLast(E object);
    boolean insertAt(int index, E object);
    // DELETE
    E deleteFirst();
    E deleteLast();
    E delete(int index);
    boolean delete(E object);
    // SEARCH
    boolean search(E object);
    // Display
    void display();
}
