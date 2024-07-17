package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 *
 * @author : ZhouBin
 */
public class HSTest006 {

    private static List<List<String>> result = new ArrayList<>();
    private static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtrack("aab", 0);
        System.out.println(JSONObject.toJSONString(result));

    }

    private static void backtrack(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (isPalindrome(substring)) {
                path.add(substring);
                backtrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
