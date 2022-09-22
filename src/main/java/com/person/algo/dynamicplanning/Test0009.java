package com.person.algo.dynamicplanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割等和子集  ※※※※※ ?
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200
 * 示例 1: 输入: [1, 5, 11, 5] 输出: true 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2: 输入: [1, 2, 3, 5] 输出: false 解释: 数组不能分割成两个元素和相等的子集.
 *
 * @author : ZhouBin
 * @date : 2022/9/21
 */
public class Test0009 {

    /**
     * 记录子集元素下标
     */
    private static int[] flag;

    /**
     * 元素子集集合
     */
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7};
        Arrays.sort(arr);
        flag = new int[arr.length];
        int sum = 9;
        calculateSum(arr, sum, arr.length - 1);
        System.out.println(result);
    }

    /**
     * 支持数组分割N个子集 和等于 指定数
     * 递归算法：取 length-1 元素开始,计算出和为sum的元素下标。
     */
    private static void calculateSum(int[] arr, int sum, int length) {

        int index;
        if (sum == 0) {
            List<Integer> r = new ArrayList<>();
            for (index = 0; index < flag.length; index++) {
                if (flag[index] > 0) {
                    r.add(arr[index]);
                }
            }
            result.add(r);
        }
        for (index = length; index >= 0; index--) {
            int n = sum - arr[index];
            if (flag[index] == 0 && n >= 0) {
                flag[index] = 1;
                calculateSum(arr, n, index - 1);
                flag[index] = 0;
            }
        }
    }
}
