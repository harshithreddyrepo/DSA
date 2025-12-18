package DSA_with_kunal.StackAndQueue;

public class Main {
    public static void main(String[] args) throws QueueException {
        CircularQueue queue=new CircularQueue(5);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(11);
        queue.enqueue(9);
        queue.enqueue(12);
        queue.dequeue();
        queue.enqueue(13);

        queue.display();

    }
}
