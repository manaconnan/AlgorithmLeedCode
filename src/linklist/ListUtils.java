package linklist;

/**
 * @Author mazexiang
 * @CreateDate 2017/12/4
 * @Version 1.0
 */
public class ListUtils {

    public static Node createList(int[] nums){
        if(nums.length==0){
            return null;
        }
        Node head = new Node(nums[0]);
        Node cur = head;
        for(int i =1;i<nums.length;i++){
            cur.next = new Node(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printLinkedList(Node head){
        Node cur = head;
        while (cur!=null){
            System.out.print(cur.getVal()+" -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] nums ={1,1,3,3,4,5,6};
        Node head = ListUtils.createList(nums);
        ListUtils.printLinkedList(head);
    }
}
