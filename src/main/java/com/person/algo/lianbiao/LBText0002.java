package com.person.algo.lianbiao;

/**
 * 题意：反转一个单链表。
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 *
 * @author : ZhouBin
 */
public class LBText0002 {

    public static void main(String[] args) {
        ListNode headNode = ListNode.initNode(new int[]{1, 2, 3, 4, 5});
//        ListNode reverse = reverse(null,headNode);
        ListNode reverse = reverse2(headNode);
        System.out.println(reverse.toPlanStr());
    }

    /**
     * 递归调用
     */
    private static ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode tempNode = cur.next;
        cur.next = prev;
        return reverse(cur, tempNode);

    }

    /**
     * 双指针法
     */
    private static ListNode reverse2(ListNode head) {
        ListNode pre =null;
        ListNode cur =head;
        ListNode temp = null;
        while (cur != null){
            temp =cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
