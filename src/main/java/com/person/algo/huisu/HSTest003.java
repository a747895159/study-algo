package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 手机电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author : ZhouBin
 */
public class HSTest003 {

    private static List<String> result = new ArrayList<>();

    private static StringBuilder temp = new StringBuilder();
    ;

    public static void main(String[] args) {
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack("27", numString, 0);
        System.out.println(JSONObject.toJSONString(result));
    }

    private static void backtrack(String digits, String[] numString, int start) {
        if (start == digits.length()) {
            result.add(temp.toString());
            return;
        }
        //获取当前位(start)数字对应的char --> ascii ,再减去 '0'
        String str = numString[digits.charAt(start) - '0'];
//        String str = numString[Integer.parseInt(digits.substring(start, start + 1))];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //递归，处理下一层
            backtrack(digits, numString, start + 1);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

}
