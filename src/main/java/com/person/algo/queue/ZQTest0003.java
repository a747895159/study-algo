package com.person.algo.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * @author : ZhouBin
 */
public class ZQTest0003 {

    public static void main(String[] args) {
        String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int valid = calc(arr);

        System.out.println(valid);

    }

    private static int calc(String[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // LinkedList 双端队列，可以当做栈使用
        Deque<Integer> queue = new LinkedList<>();
        //用Stack也可以
        //Stack<Character> queue = new Stack<>();
        for (String s : arr) {
            if (s.equals("+")) {
                queue.push(queue.pop() + queue.pop());

            } else if (s.equals("-")) {
                queue.push(-queue.pop() + queue.pop());

            } else if (s.equals("*")) {
                queue.push(queue.pop() * queue.pop());

            } else if (s.equals("/")) {
                int temp1 = queue.pop();
                int temp2 =queue.pop();
                queue.push(temp2 / temp1);
            } else {
                queue.push(Integer.parseInt(s));
            }
        }
        return queue.pop();
    }

}
