package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和III
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
public class HSTest003 {

    private static List<List<Integer>> result = new ArrayList<>();

    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Arrays.sort(nums);
        backTrack(4, nums, 0, 0);
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
        //递归起始 如果0 ，则是求的排列，排列强调顺序，(1,5)和(5,1)是两个不同的排列。
        //递归起始 如果是start ，则是求组合，组合不关心顺序，(1,5)和(5,1)是同一个组合。
        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            curSum += arr[i];
            backTrack(target, arr, curSum, i);
            curSum -= arr[i];
            path.remove(path.size() - 1);
        }

    }
}
