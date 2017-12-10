package leedCode;

import linklist.ListUtils;
import linklist.Node;

/**
 * @Author mazexiang
 * @CreateDate 2017/12/4
 * @Version 1.0
 */
public class Problem83 {

    public static   Node deleteDuplicates( Node head) {
        if(head ==null|| head.next==null){
            return head;
        }

         Node first = head;
         Node second = head.next;

        while(second!=null){
            while(second!=null&& first.getVal()==second.getVal()){
                second = second.next;
            }

            first.next = second;
            first = second;
            if(second!=null)
                second = second.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums ={1,1,1,1};
        Node head = ListUtils.createList(nums);
        ListUtils.printLinkedList(head);
        Node newHead= Problem83.deleteDuplicates(head);
        ListUtils.printLinkedList(newHead);
    }
}
