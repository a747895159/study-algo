package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author : ZhouBin
 */
public class HSTest002 {

    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();


    public static void main(String[] args) {
        result = new ArrayList<>();
        backTrack(9, 3, 1, 0);
        System.out.println(JSONObject.toJSONString(result));
    }

    private static void backTrack(int targetSum, int k, int start, int sum) {
        //减枝
        if (sum > targetSum) {
            return;
        }
        if (sum == targetSum && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        //减枝
        for (int i = start; i <= 9 - k + path.size() + 1; i++) {
            path.add(i);
            sum += i;
            backTrack(targetSum, k, i + 1, sum);
            sum -= i;
            path.remove(path.size() - 1);
        }

    }
}
