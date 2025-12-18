package DSA_with_kunal.StackAndQueue;

public class CircularQueue {
    protected int front;
    protected int rear;
    protected int[] data;
    static final int DEFAULT_SIZE=10;
    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        data=new int[size];
        front=0;
        rear=0;
    }

    public boolean enqueue(int e){
        if(isFull()){
            return false;
        }
        data[rear%data.length]=e;
        rear++;
        return true;
    }

    public int dequeue() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Cannot remove the element from empty queue!!");
        }
        int val=data[front%data.length];
        front++;
        return val;
    }

    public int first() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Cannot get element from the empty Queue!!");
        }
        return data[front%data.length];
    }

    public void display(){
        for(int i=front;i<rear;i++){
            System.out.print(data[i%data.length]+"->");
        }
        System.out.println("end");
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public boolean isFull(){
        return rear > front && rear % data.length == front % data.length;
    }
}
