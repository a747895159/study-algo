package com.person.algo.dynamicplanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个只包含正整数的非空数组和一个定值num。将这个数组分割成N个子集，使得N个子集的元素和num。
 * 元素可重复
 *
 * @author : ZhouBin
 * @date : 2022/9/22
 */
public class Test0010 {

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
        int sum = 8;
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
