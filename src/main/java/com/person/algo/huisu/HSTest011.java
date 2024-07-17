package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 * @author : ZhouBin
 */
public class HSTest011 {
    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();
    private static boolean[] used;

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        backTracking(nums);

        int[] nums = {1, 1, 2};
        used = new boolean[nums.length];
        backTracking2(nums, used);
        System.out.println(JSONObject.toJSONString(result));
    }

    /**
     * 全排列  数组不重复的场景
     */
    private static void backTracking(int[] arr) {
        if (path.size() == arr.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (path.contains(arr[i])) {
                continue;
            }
            path.add(arr[i]);
            backTracking(arr);
            path.remove(path.size() - 1);

        }
    }

    /**
     * 全排列  数组元素重复的场景
     */
    private static void backTracking2(int[] arr, boolean[] used) {
        if (path.size() == arr.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                if(used[i - 1] == false){
                    continue;
                }
            }
            if (!used[i]) {
                used[i] = true;
                path.add(arr[i]);
                backTracking2(arr, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
