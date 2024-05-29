package com.person.algo.lianbiao;

/**
 * 142. 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 *
 * @author : ZhouBin
 */
public class LBText0005 {

    public static void main(String[] args) {
        ListNode head = ListNode.initNode(new int[]{1, 2, 3, 4, 5});
        ListNode curr = head;
        ListNode tempNode = null;
        int i = 0;
        while (curr != null) {
            i++;
            if (i == 3) {
                tempNode = curr;
            }
            curr = curr.next;
            if (curr.next == null) {
                break;
            }
        }
        curr.next = tempNode;
        ListNode listNode = detectCycle(head);
        System.out.println(listNode.val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
