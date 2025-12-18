package DSA_with_kunal.StackAndQueue;

public class DynamicQueue {
    protected int size;
    protected int front;
    protected int end;
    protected int[] data;
    static final int DEFAULT_SIZE=10;

    public DynamicQueue(){
        this(DEFAULT_SIZE);
    }

    public DynamicQueue(int size) {
        size=0;
        front=0;
        end=0;
        data=new int[size];
    }

    public boolean enqueue(int e){
        if(isFull()){
            // Increase the size of the array
            int[] temp=new int[data.length*2];
//            int i=0;
//            do{
//                temp[i]=data[front++];
//                i++;
//                front=front%data.length;
//            }while (front!=end);

            for(int i=0;i<data.length;i++){
                temp[i]=data[(front+i)%data.length];
            }
            front=0;
            end=data.length;
            data=temp;
        }
        data[end++]=e;
        end%=data.length;
        size++;
        return true;
    }

    public int dequeue() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Cannot remove the element form the empty queue!!");
        }
        int removed=data[front++];
        front%=data.length;
        size--;
        return removed;
    }

    public int first() throws QueueException {
        if(isEmpty()){
            throw new QueueException("Cannot get the element form the empty queue!!");
        }
        return data[front];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("The queue is empty!!");
            return;
        }
        int i=front;
        do{
            System.out.print(data[i++]+"->");
            i%=data.length;
        }while(i!=end);
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return size==data.length;
    }
}
