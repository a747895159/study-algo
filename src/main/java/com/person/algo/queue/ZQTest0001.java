package com.person.algo.queue;

import org.apache.commons.lang3.StringUtils;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * @author : ZhouBin
 */
public class ZQTest0001 {

    public static void main(String[] args) {
        String s = "{[]()}";
        boolean valid = isValid(s);

        System.out.println(valid);

    }

    private static boolean isValid(String s) {
        if (StringUtils.isBlank(s)) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        // LinkedList 双端队列，可以当做栈使用
        Deque<Character> queue = new LinkedList<>();
        //用Stack也可以
        //Stack<Character> queue = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                queue.push(c);
            } else {
                if (queue.isEmpty() || queue.pop() != map.get(c)) {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }

}
