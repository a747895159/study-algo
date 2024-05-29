package com.person.algo.lianbiao;

/**
 * 两两交换链接表中的节点
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * @author : ZhouBin
 */
public class LBText0003 {

    public static void main(String[] args) {
        ListNode headNode = ListNode.initNode(new int[]{1, 2, 3, 4});
        System.out.println(swapPairs02(headNode).toPlanStr());
    }

    /**
     * 迭代法
     */
    private static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    /**
     * 递归法
     */
    private static ListNode swapPairs02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs02(temp.next);
        temp.next = head;
        return temp;

    }
}
