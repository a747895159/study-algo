package com.person.algo.lianbiao;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toPlanStr() {
        List<Integer> list = new ArrayList<>();
        ListNode node = this;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return JSONObject.toJSONString(list);
    }

    public static ListNode initNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode tailNode = new ListNode(nums[nums.length - 1]);
        ListNode node = null;
        for (int i = nums.length - 2; i >= 0; i--) {
            node = node == null ? tailNode : node;
            node = new ListNode(nums[i], node);
        }
        return node;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5};

        initNode(arr);
    }
}