package leedCode;

import linklist.Node;

import java.nio.file.NotDirectoryException;

/**
 * @Author mazexiang
 * @CreateDate 2017/12/3
 * @Version 1.0
 *
 *Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 *
 *
 */

public class Proble92 {
    public Node reverseBetween(Node head, int m, int n) {
        if(head==null||head.next==null){
            return head;
        }
        Node preNode = null;
        Node curNode = head;
        Node beforeNode = null; // 保存m 点之前的那个Node
        int p = 0 ;
        Node nextNode = curNode.next;
        while (p<m && curNode!=null){
            // 初始三个指针的位置
            preNode = curNode;
            beforeNode = preNode;
            curNode = nextNode;
            nextNode = curNode.next;
            p++;
        }
        // p == m

        while (p<=n){
            //TODO
        }

        return null;

    }


}
