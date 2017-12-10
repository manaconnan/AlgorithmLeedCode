import java.lang.reflect.Array;
import java.util.PriorityQueue;

public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY =10;
    private T[] array;
    private int currentSize;
    public BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }
    public BinaryHeap(int capacity){
        currentSize = 0;
        array = (T[])new Comparable[capacity+1];
    }


    public BinaryHeap(T[] arr){
        int n = arr.length;
        array = (T[])new Comparable[n+1];
        for (int i=0;i<n;i++){
            array[i+1] = arr[i];
        }
        currentSize = n;
        //Heapify的过程
        for (int i = n/2; i>0;i--){ // 一个数组，所有的叶子节点都是最小堆，而第一个非叶子节点是n/2，所以这里从n/2开始shiftDown
            shiftDown(i);
        }
    }

  

    public void insert(T item){
        array[currentSize+1] = item;
        currentSize++;
        percolateUp(currentSize);
    }


    public T deletMin() throws Exception {
        if(isEmpty()){
            throw  new Exception("empty heap");
        }
        T t = array[1];
        array[1] = array[currentSize];
        shiftDown(1);
        currentSize--;
        return  t;
    }
    private void shiftDown(int k){
        T temp = array[k];

        while (2*k<currentSize){
            int j = 2*k ;//在此轮循环中，array[k] 和array[j]交换
            if(j+1<currentSize&&array[j+1].compareTo(array[j])<0){ //有右孩子， 而且右孩子比左孩子小，总是和比较小的那个孩子交换
                j = j+1;
            }
            if(temp.compareTo(array[j])<=0){
                break;//不用交换
            }
            array[k] = array[j];
            k=j;
        }
        array[k] = temp;
    }

    private void percolateUp(int k){
         T temp;
         temp = array[k];
        while (k>1&&array[k/2].compareTo(temp)>0){
            array[k] = array[k/2];
            k/=2;
        }
        array[k] = temp;
    }

    public int size(){
        return currentSize;
    }
    public boolean isEmpty(){
        return currentSize==0;
    }


    public static void main(String[] args) throws Exception {
        BinaryHeap<Integer> heap = new BinaryHeap<>(100);
        
        heap.insert(3);
        heap.insert(2);
        heap.insert(5);
        heap.insert(10);
        heap.insert(1);
        heap.insert(4);
        heap.insert(16);
        while (!heap.isEmpty()){
            System.out.println("====> " + heap.deletMin());
        }
      
        Integer[] ints = {3,2,5,2,1,6,8,4};
        BinaryHeap<Integer> heap1 = new BinaryHeap(ints);

        while (!heap1.isEmpty()) {
            System.out.println(  heap1.deletMin());
        }


    }

}
