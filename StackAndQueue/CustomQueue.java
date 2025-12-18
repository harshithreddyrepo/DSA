package DSA_with_kunal.StackAndQueue;

/*
   Methods in Queue:
   1.enqueue()
   2.dequeue()
   3.first()
   4.size()
   5.isEmpty()
 */
public class CustomQueue {
    protected int end;
    protected int[] data;
    static final int DEFAULT_SIZE=10;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        data=new int[size];
        end=0;
    }

    public boolean enqueue(int e){
        if(isFull()){
            return false;
        }
        data[end++]=e;
        return true;
    }

    public int dequeue() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Cannot remove element from the empty queue!!");
        }
        int val=data[0];
        for(int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return val;
    }

    public int first() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Cannot get element from the empty Queue!!");
        }
        return data[0];
    }

    public boolean isEmpty(){
        return end==0;
    }

    public boolean isFull(){
        return end==data.length;
    }

}
