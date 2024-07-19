package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出：[[1,2,2],[5]]
 *
 * @author : ZhouBin
 */
public class HSTest004 {

    private static List<List<Integer>> result = new ArrayList<>();

    private static List<Integer> path = new ArrayList<>();

    private static boolean[] used;

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 5, 6, 7, 10};
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTrack(8, nums, 0, 0);
        System.out.println(JSONObject.toJSONString(result));
    }

    private static void backTrack(int target, int[] arr, int curSum, int start) {
        if (target == curSum) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }
            if (curSum + arr[i] > target) {
                break;
            }
            path.add(arr[i]);
            curSum += arr[i];
            used[i] = true;
            backTrack(target, arr, curSum, i + 1);
            curSum -= arr[i];
            path.remove(path.size() - 1);
            used[i] = false;
        }

    }
}
