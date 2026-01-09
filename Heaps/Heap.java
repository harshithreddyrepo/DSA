package DSA_with_kunal.Heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap <T extends Comparable<T>> {
    List<T> list;
    public Heap(){
        list=new ArrayList<>();
    }
    private void swap(int first, int second){
        T temp=list.get(first);
        list.add(first, list.get(second));
        list.add(second, temp);
    }
    private int getParent(int i){
        return (i-1)/2;
    }
    private int getLeft(int i){
        return (i*2)+1;
    }
    private int getRight(int i){
        return (i*2)+2;
    }
    private void insert(T val){
        // Add the value at last and call upHeap()
        list.add(val);
        upHeap(list.size()-1);
    }

    private void upHeap(int i) {
        if(i==0){  // root node
            return;
        }
        int parent=getParent(i);
        if(list.get(parent).compareTo(list.get(i))>0) // returns true if value of parent node is greater than node value
        {
            // Min Heap
            swap(i, parent);
            upHeap(parent);
        }
    }

    private T remove() throws Exception {
        if(list.isEmpty()){
            throw new Exception("Can not remove element form the empty heap");
        }
        T result=list.get(0);
        list.add(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        if(!list.isEmpty()){
            downHeap(0);
        }
        return result;
    }

    private void downHeap(int i) {
        if(getLeft(i)>=list.size()){
            return;
        }
        int min=i;
        if(list.get(i).compareTo(list.get(getLeft(i)))>0) // returns true if value  of left child is lesser than value of node
        {
            min=getLeft(i);  // min is now at left child.
        }
        if(getRight(i)<list.size() && list.get(min).compareTo(list.get(getRight(i)))>0){
            min=getRight(i);
        }
        if(min!=i){  // either left child or right child is smallest among three nodes
           swap(i, min);
           downHeap(min);
        }
    }
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data=new ArrayList<>();
        while (!list.isEmpty()){
            data.add(remove());
        }
        return data;
    }
}
