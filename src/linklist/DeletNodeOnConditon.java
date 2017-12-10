package linklist;

import java.util.ArrayList;
import java.util.Arrays;

public class DeletNodeOnConditon {

    /**
     * delete node when the node value equals @param value
     * @param head
     * @param value
     * @return
     */
    public static <T> Node<T> getNewNodeOnCondtion(Node<T> head, T value){
        Node<T> pointNode =null;
        while (head!=null&& head.getVal()==value){
            head=head.getNext();
        }

        if (head==null){
            return null;
        }

        pointNode = head;

        while ( pointNode.getNext()!=null){




            if(pointNode.getNext().getVal()==value){
                pointNode.setNext(pointNode.getNext().getNext());

            }else {

                pointNode=pointNode.getNext();

            }


        }

        return head;
    }

    public static void main(String[] args) {
        Node linkedList = LinkedListCreator.createLinkedList(Arrays.asList(3,3,1, 2, 3, 4, 3,3,3,3,3,3, 5, 3, 6,3,3,3));
        Node.printLinkedList(linkedList);
        Node newNodeOnCondtion = DeletNodeOnConditon.getNewNodeOnCondtion(linkedList, 1);
        Node.printLinkedList(newNodeOnCondtion);
    }

}
