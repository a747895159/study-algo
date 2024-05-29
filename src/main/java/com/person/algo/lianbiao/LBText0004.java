package com.person.algo.lianbiao;

/**
 * 删除链表的倒数第N个节点
 *
 * @author : ZhouBin
 */
public class LBText0004 {
    public static void main(String[] args) {
        ListNode node1 = ListNode.initNode(new int[]{1, 2, 3, 4, 5});

        System.out.println(removeNthFromEnd(node1, 5).toPlanStr());
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        n = n + 1;
        int i = 0;
        ListNode node = dummyHead;
        ListNode tempNode = null;
        while (node != null) {
            if (i == n - 1) {
                tempNode = node;
            }
            if (i == n) {
                tempNode.next = node.next;
            }
            i++;
            node = node.next;
        }
        return dummyHead.next;
    }
}
