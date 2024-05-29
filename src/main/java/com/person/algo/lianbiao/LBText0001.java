package com.person.algo.lianbiao;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 * 示例 2： 输入：head = [], val = 1 输出：[]
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 *
 * @author : ZhouBin
 */
public class LBText0001 {

    public static void main(String[] args) {
        ListNode headNode = ListNode.initNode(new int[]{7, 8, 7, 9});
        ListNode listNode = removeElements(headNode, 7);
        System.out.println(listNode.toPlanStr());
    }


    public static ListNode removeElements(ListNode head, int val) {
        //输入：head = [7,7,7,7], val = 7 输出：[]
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;


    }
}
