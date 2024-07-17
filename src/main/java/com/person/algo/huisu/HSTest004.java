package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为： [ [7], [2,2,3] ]
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为： [ [2,2,2,2], [2,3,3], [3,5] ]
 *
 * @author : ZhouBin
 */
public class HSTest004 {

    private static List<List<Integer>> result = new ArrayList<>();

    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        Arrays.sort(nums);
        backTrack(8, nums, 0, 0);
        System.out.println(JSONObject.toJSONString(result));
    }

    private static void backTrack(int target, int[] arr, int curSum, int start) {
        if (curSum > target) {
            return;
        }
        if (target == curSum) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            curSum += arr[i];
            backTrack(target, arr, curSum, i);
            curSum -= arr[i];
            path.remove(path.size() - 1);
        }

    }
}
