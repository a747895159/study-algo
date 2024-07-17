package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 *
 * @author : ZhouBin
 */
public class HSTest009 {

    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {4,4,4,1,4};
        Arrays.sort(arr);
        backTracking(arr, 0);
//        result.add(new ArrayList<>());
        System.out.println(JSONObject.toJSONString(result));

    }

    private static void backTracking(int[] arr, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < arr.length; i++) {
            if(i>startIndex && arr[i] == arr[i-1]){
                continue;
            }
            path.add(arr[i]);
            backTracking(arr, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
