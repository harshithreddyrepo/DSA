package DSA_with_kunal.StackAndQueue;
/*
  Methods in StackAndQueue:
    1.push()
    2.pop()
    3.peek()
    4.size()
    5.empty()
 */
public class CustomStack {
    protected int top;
    protected int[] data;
    private static final int DEFAULT_SIZE =10;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        top=-1;
        data =new int[size];
    }
    // push()
     public boolean push(int e){
        if(isFull()){
            return false;
        }
        data[++top]=e;
        return true;
     }

     // pop()
    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot pop element from empty stack!!");
        }
        return data[top--];
    }

    //peek()
    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot peek element from empty stack!!");
        }
        return data[top];
    }

    //size()
    public int size(){
        return top+1;
    }

    public boolean isFull() {
        return top==data.length;
    }
     //isEmpty
    public boolean isEmpty(){
        return top==-1;
    }
}
