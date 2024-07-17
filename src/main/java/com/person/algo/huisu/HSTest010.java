package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 递增子序列
 * 给定一个整型无序数组, 找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * @author : ZhouBin
 */
public class HSTest010 {

    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7,4,6,8};
        backTracking(nums, 0);
        System.out.println(JSONObject.toJSONString(result));

    }

    private static void backTracking(int[] arr, int startIndex) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < arr.length; i++) {
            //同一父节点下的同层上使用过的元素就不能再使用了,   且所取元素小于最后节点时
            if (!path.isEmpty() && path.get(path.size() - 1) > arr[i] || hs.contains(arr[i])) {
                continue;
            }
            hs.add(arr[i]);
            path.add(arr[i]);
            backTracking(arr, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
