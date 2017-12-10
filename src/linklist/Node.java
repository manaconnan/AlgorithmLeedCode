package linklist;

import java.awt.*;

public class Node<T> {

    private final T val;
    public Node<T> next;
    public Node(T val){
        this.val = val;
        this.next=null;
    }

    public T getVal() {
        return val;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public static <T> void printLinkedList(Node<T> head){
        while (head!=null){
            System.out.print(head.getVal()+" ");
            head=head.getNext();
        }
        System.out.println();
    }
}
