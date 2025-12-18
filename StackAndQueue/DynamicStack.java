package DSA_with_kunal.StackAndQueue;

public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }
    @Override
    public boolean push(int e){
       if(isFull()) {
           int[] temp=new int[data.length*2];
           System.arraycopy(data, 0, temp, 0, data.length);
           data=temp;
       }
       return super.push(e);
    }
}
