package DSA_with_kunal.StackAndQueue.Questions;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        int maxSum=10;
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        a.add(4);
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(1);

        b.add(2);
        b.add(1);
        b.add(8);
        b.add(5);

        System.out.println(twoStacks(maxSum,a, b));

    }

    // Q2. Game of two stacks
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        Stack<Integer>  aStack=new Stack<>();
        Stack<Integer>  bStack=new Stack<>();
        for(int i=a.size();i>0;i--){
            aStack.push(a.get(i-1));
        }
        for(int i=b.size();i>0;i--){
            bStack.push(b.get(i-1));
        }

        return helper(maxSum, aStack, bStack, 0, 0);

    }

    public static int helper(int maxSum, Stack<Integer> a, Stack<Integer> b, int sum, int count){
        if(sum>maxSum){
            return count-1;
        }

        if (a.empty() && b.empty()) {
            return count;
        }

        int left=0;
        int right=0;

        if(!a.empty()){
            int aPop=a.pop();;
            left=helper(maxSum, a, b, sum+aPop, count+1);
            a.push(aPop);
        }

        if(!b.empty()){
            int bPop=b.pop();
            right=helper(maxSum, a, b, sum+bPop, count+1);
            b.push(bPop);
        }

        return Math.max(left, right);
    }


}

//Q1. Implement queue using stacks
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(!s2.empty()){
            return s2.pop();
        }
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek() {
        if(!s2.empty()){
            return s2.peek();
        }
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}

