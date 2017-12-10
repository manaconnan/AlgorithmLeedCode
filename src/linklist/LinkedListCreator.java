package linklist;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCreator {

    public static Node createLinkedList(List<Integer> list){
        if (list.isEmpty()){
            return null;
        }
        Node<Integer> firstNode = new Node<>(list.get(0));
        Node<Integer> headOfSubList = createLinkedList(list.subList(1,list.size()));
        firstNode.setNext(headOfSubList);

        return firstNode;

    }



    public static void main(String[] args) {


    }
}
