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
     3.Update
     -> E update(int index) // updates the value and returns the previous value if present.
     3.Search
     -> boolean search(E object)
     4.display
     -> void display()
*/
public interface LLI<E> {

    // INSERT
    void insertFirst(E data);
    void insertLast(E data);
    boolean insert(int index, E data);

    // DELETE
    E deleteFirst();
    E deleteLast();
    E delete(int index);
    boolean delete(E data);

    // UPDATE
    E update(int index, E data);

    // SEARCH
    boolean search(E data);

    // Fetch
    E get(int index);
    void display();
}
