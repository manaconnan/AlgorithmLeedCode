package linklist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedIntegerList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedIntegerList (){
        head=null;
        tail=null;
    }

    public void add(T element){
        Node<T> addNode = new Node<>(element);
        if(tail==null){
            head=addNode;
        }else {
            tail.setNext(addNode);
        }

        tail=addNode;
    }

    private class  ListIterator implements Iterator<T>{

       private Node<T> currentNode;

        public ListIterator (Node<T> head){
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode!=null;
        }

        @Override
        public T next() {
            if(currentNode==null){
                throw  new NoSuchElementException();
            }
            T value = currentNode.getVal();
            currentNode = currentNode.getNext();

            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {

        ListIterator iterator = new ListIterator(head);

        return iterator;
    }


}
