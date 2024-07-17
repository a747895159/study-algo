package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * @author : ZhouBin
 */
public class HSTest007 {

    private static List<String> result = new ArrayList<>();
    private static List<String> path = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) {
        backTracking("101023", 0);

        System.out.println(JSONObject.toJSONString(result));

    }

    private static void backTracking(String s, int startIndex) {
        if (path.size() == 4) {
            if (count != s.length()) {
                return;
            }
            String join = String.join(".", path);
            result.add(join);
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (i > startIndex && (s.charAt(startIndex) == '0' || i - startIndex > 3 || Integer.parseInt(substring) > 255)) {
                return;
            }
            count = count + i - startIndex + 1;
            path.add(substring);
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
            count = count - i + startIndex - 1;
        }


    }


}
