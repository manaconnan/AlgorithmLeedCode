package linklist;

public class ReverseLinkedList {

    /**
     * Reverse a linked list 递归的方法
     * @param head head of linked list to reverse
     * @return head of reversed linked list
     */
    public Node reverseLinkedList(Node head){

        if(head==null){
            return null;
        }
        if(head.getNext()==null){
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;

    }

    //循环的方法  三个指针
    public Node reverseLinkedList2(Node head){
        Node preNode = null;
        Node curNode = head;
        while (curNode!=null){
            Node nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

}
